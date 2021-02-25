package cn.az.replica.mall.controller.mall;

import cn.az.replica.mall.constant.Constants;
import cn.az.replica.mall.controller.vo.GoodsCategoryVo;
import cn.az.replica.mall.entity.Carousel;
import cn.az.replica.mall.entity.GoodsInfo;
import cn.az.replica.mall.enums.IndexConfigType;
import cn.az.replica.mall.service.ICarouselService;
import cn.az.replica.mall.service.IGoodsCategoryService;
import cn.az.replica.mall.service.IGoodsInfoService;
import cn.az.replica.mall.service.IndexConfigService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author az
 * @since 2020-04-07
 */
@Controller
public class MallController {

    @Resource
    private IGoodsCategoryService goodsCategoryService;

    @Resource
    private IGoodsInfoService goodsInfoService;

    @Resource
    private ICarouselService carouselService;

    @Resource
    private IndexConfigService indexConfigService;

    @GetMapping("index")
    public String index(HttpServletRequest req) {
        List<GoodsCategoryVo> root = goodsCategoryService.treeList();
        List<GoodsInfo> hotGoods = indexConfigService.listIndexConfig(IndexConfigType.INDEX_GOODS_HOT, Constants.INDEX_GOODS_HOT_NUMBER);
        List<GoodsInfo> newGoods = indexConfigService.listIndexConfig(IndexConfigType.INDEX_GOODS_NEW, Constants.INDEX_GOODS_NEW_NUMBER);
        List<GoodsInfo> recommendGoods = indexConfigService.listIndexConfig(IndexConfigType.INDEX_GOODS_RECOMMEND, Constants.INDEX_GOODS_RECOMMEND_NUMBER);

        List<Carousel> carousels = carouselService.list(Wrappers.<Carousel>query()
                .orderByDesc("carousel_rank"));
        req.setAttribute("categories", root);
        req.setAttribute("carousels", carousels);
        req.setAttribute("hotGoodses", hotGoods);
        req.setAttribute("newGoodses", newGoods);
        req.setAttribute("recommendGoodses", recommendGoods);
        return "mall/index";
    }
}
