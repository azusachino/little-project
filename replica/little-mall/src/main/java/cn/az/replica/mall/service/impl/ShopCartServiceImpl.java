package cn.az.replica.mall.service.impl;

import cn.az.replica.mall.controller.vo.ShopCartVo;
import cn.az.replica.mall.entity.GoodsInfo;
import cn.az.replica.mall.entity.ShopCart;
import cn.az.replica.mall.exception.MallException;
import cn.az.replica.mall.mapper.ShopCartMapper;
import cn.az.replica.mall.service.IGoodsInfoService;
import cn.az.replica.mall.service.IShopCartService;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author az
 */
@Service
public class ShopCartServiceImpl extends ServiceImpl<ShopCartMapper, ShopCart> implements IShopCartService {

    @Resource
    private IGoodsInfoService goodsInfoService;

    private static final Integer MAX_GOODS_COUNT = 10;
    private static final Integer MAX_CART_COUNT = 15;

    @Override
    public void saveCart(ShopCart item) {
        GoodsInfo goodsInfo = goodsInfoService.getById(item.getGoodsId());
        ShopCart cartItem = getById(item.getCartItemId());
        if (Objects.isNull(cartItem)) {
            cartItem = getOne(Wrappers.<ShopCart>query()
                    .eq("user_id", item.getUserId())
                    .eq("goods_id", item.getGoodsId()));
            if (Objects.nonNull(cartItem)) {
                item.setGoodsCount(cartItem.getGoodsCount());
            }
        } else {
            int goodsCount = item.getGoodsCount();
            cartItem.setGoodsCount(goodsCount == 0 ? 1 : goodsCount);
            if (cartItem.getGoodsCount() > MAX_GOODS_COUNT) {
                throw new MallException("该商品最多购买10个");
            }
            updateById(cartItem);
            return;
        }
        // 商品已经下架
        if (goodsInfo.getGoodsSellStatus() == 1) {
            throw new MallException("该商品已经下架");
        }
        // 超出单个商品的最大数量
        if (item.getGoodsCount() > MAX_GOODS_COUNT) {
            throw new MallException("该商品最多购买10个");
        }
        int count = count(Wrappers.<ShopCart>query().eq("user_id", item.getUserId()));
        // 购物车选购商品数量超出最大数量
        if (count > MAX_CART_COUNT) {
            throw new MallException("购物车商品超出最大数量");
        }
        save(item);
    }

    @Override
    public List<ShopCartVo> getCart(Long userId) {
        List<ShopCartVo> collection = new ArrayList<>();
        List<ShopCart> carts = list(Wrappers.<ShopCart>query().eq("user_id", userId));
        List<Long> goodsIds = carts.stream().map(ShopCart::getGoodsId).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(goodsIds)) {
            List<GoodsInfo> goodsInfos = goodsInfoService.listByIds(goodsIds);
            Map<Long, GoodsInfo> goodsInfoMap = goodsInfos.stream()
                    .collect(Collectors.toMap(GoodsInfo::getGoodsId, i -> i));
            collection.addAll(carts.stream().map(c -> {
                ShopCartVo cartVo = new ShopCartVo();
                BeanUtils.copyProperties(c, cartVo);
                if (goodsInfoMap.containsKey(c.getGoodsId())) {
                    GoodsInfo goodsInfo = goodsInfoMap.get(c.getGoodsId());
                    cartVo.setGoodsName(goodsInfo.getGoodsName());
                    cartVo.setSellingPrice(goodsInfo.getSellingPrice());
                    cartVo.setGoodsCoverImg(goodsInfo.getGoodsCoverImg());
                }
                return cartVo;
            }).collect(Collectors.toList()));
        }
        return collection;
    }
}
