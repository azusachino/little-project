package cn.az.replica.mall.service.impl;

import cn.az.replica.mall.controller.vo.OrderListVo;
import cn.az.replica.mall.controller.vo.ShopCartVo;
import cn.az.replica.mall.controller.vo.UserVo;
import cn.az.replica.mall.entity.GoodsInfo;
import cn.az.replica.mall.entity.Order;
import cn.az.replica.mall.entity.OrderItem;
import cn.az.replica.mall.exception.MallException;
import cn.az.replica.mall.mapper.OrderMapper;
import cn.az.replica.mall.service.IGoodsInfoService;
import cn.az.replica.mall.service.IOrderItemService;
import cn.az.replica.mall.service.IOrderService;
import cn.az.replica.mall.service.IShopCartService;
import cn.az.replica.mall.util.NumberUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author az
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Resource
    private IGoodsInfoService goodsInfoService;

    @Resource
    private IShopCartService shopCartService;

    @Resource
    private IOrderItemService orderItemService;

    /**
     * Save order string.
     *
     * @param userVo         the user vo
     * @param shopCartVoList the shop cart vo list
     * @return the string
     */
    @Override
    @Transactional(rollbackFor = SQLException.class)
    public String saveOrder(UserVo userVo, List<ShopCartVo> shopCartVoList) {
        List<Long> goodsIdList = shopCartVoList.stream().map(ShopCartVo::getGoodsId).collect(Collectors.toList());
        List<Long> cartItemIdList = shopCartVoList.stream().map(ShopCartVo::getCartItemId).collect(Collectors.toList());

        List<GoodsInfo> goods = goodsInfoService.listByIds(goodsIdList);

        // check goods if not exist
        List<GoodsInfo> notExistGoods = goods.stream().filter(g -> g.getGoodsSellStatus() == 1).collect(Collectors.toList());

        if (CollUtil.isNotEmpty(notExistGoods)) {
            throw new MallException(notExistGoods.get(0).getGoodsName() + "已下架，无法生成订单");
        }
        Map<Long, GoodsInfo> goodsMap = goods.stream().collect(Collectors.toMap(GoodsInfo::getGoodsId, g -> g));
        for (ShopCartVo shopCartVo : shopCartVoList) {
            if (!goodsMap.containsKey(shopCartVo.getGoodsId())) {
                throw new MallException("购物车中商品数据异常");
            }
            if (shopCartVo.getGoodsCount() > goodsMap.get(shopCartVo.getGoodsId()).getStockNum()) {
                throw new MallException("购物车中:" + goodsMap.get(shopCartVo.getGoodsId()).getGoodsName() + " 库存不足");
            }
        }
        if (CollUtil.isNotEmpty(goodsIdList) && CollUtil.isNotEmpty(cartItemIdList)
                && CollUtil.isNotEmpty(goods)) {
            if (shopCartService.removeByIds(cartItemIdList)) {
                List<GoodsInfo> collect = shopCartVoList.stream().map(s -> {
                    GoodsInfo info = new GoodsInfo();
                    info.setGoodsId(s.getGoodsId());
                    Integer stockNum = goodsMap.get(s.getGoodsId()).getStockNum();
                    info.setStockNum(stockNum - s.getGoodsCount());
                    return info;
                }).collect(Collectors.toList());
                if (goodsInfoService.updateBatchById(collect)) {
                    String orderNo = NumberUtil.generateOrderNo();
                    int priceTotal = 0;
                    for (ShopCartVo shopCartVo : shopCartVoList) {
                        priceTotal += shopCartVo.getSellingPrice() * shopCartVo.getGoodsCount();
                    }
                    if (priceTotal <= 0) {
                        throw new MallException("订单价格异常");
                    }
                    Order order = new Order();
                    order.setOrderNo(orderNo);
                    order.setTotalPrice(priceTotal);
                    order.setUserId(userVo.getUserId());
                    order.setUserAddress(userVo.getAddress());
                    // todo
                    order.setExtraInfo("");
                    if (save(order)) {
                        List<OrderItem> orderItems = shopCartVoList.stream().map(s -> {
                            OrderItem item = new OrderItem();
                            BeanUtils.copyProperties(s, item);
                            item.setOrderId(order.getOrderId());
                            return item;
                        }).collect(Collectors.toList());
                        if (orderItemService.saveBatch(orderItems)) {
                            return orderNo;
                        }
                    }

                }
            }
        }
        throw new MallException("生成订单异常");
    }

    /**
     * Select order list page.
     *
     * @param voPage the vo page
     * @param order  the order
     * @return the page
     */
    @Override
    public IPage<OrderListVo> selectPage(Page<OrderListVo> voPage, Order order) {
        return baseMapper.selectUserPage(voPage, Wrappers.<Order>query()
                .eq("user_id", order.getUserId())
                .orderByDesc("create_time"));
    }

    /**
     * Select page page.
     *
     * @param orderPage the order page
     * @param order     the order
     * @return the page
     */
    @Override
    public IPage<Order> selectPage(Page<Order> orderPage) {
        return baseMapper.selectPage(orderPage, Wrappers.emptyWrapper());
    }
}
