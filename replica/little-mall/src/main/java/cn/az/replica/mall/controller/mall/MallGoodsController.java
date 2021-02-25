package cn.az.replica.mall.controller.mall;

import cn.az.replica.mall.base.BaseController;
import cn.az.replica.mall.constant.Constants;
import cn.az.replica.mall.controller.vo.SearchPageCategoryVo;
import cn.az.replica.mall.controller.vo.SearchPageGoodsVo;
import cn.az.replica.mall.controller.vo.SearchParameterVo;
import cn.az.replica.mall.entity.GoodsCategory;
import cn.az.replica.mall.entity.GoodsInfo;
import cn.az.replica.mall.service.IGoodsCategoryService;
import cn.az.replica.mall.service.IGoodsInfoService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author az
 * @since 2020-04-07
 */
@Controller
public class MallGoodsController extends BaseController {

    @Resource
    private IGoodsInfoService goodsInfoService;

    @Resource
    private IGoodsCategoryService goodsCategoryService;

    @GetMapping("/search")
    public String searchPage(SearchParameterVo vo) {
        Page<SearchPageGoodsVo> page = getPage(request, Constants.GOODS_SEARCH_PAGE_LIMIT);
        String keyword = vo.getKeyword();
        request.setAttribute("keyword", keyword);
        request.setAttribute("pageResult", goodsInfoService.searchGoodsList(page, vo));
        Long goodsCategoryId = vo.getCategoryId();
        if (goodsCategoryId != null) {
            GoodsInfo goods = new GoodsInfo();
            goods.setGoodsCategoryId(goodsCategoryId);
            SearchPageCategoryVo searchPageCategoryVO = new SearchPageCategoryVo();
            GoodsCategory thirdCategory = goodsCategoryService.getById(goodsCategoryId);
            GoodsCategory secondCategory = goodsCategoryService.getById(thirdCategory.getParentId());
            List<GoodsCategory> thirdCateGoryList = goodsCategoryService.list(Wrappers.<GoodsCategory>query()
                    .eq("parent_id", thirdCategory.getParentId()));
            searchPageCategoryVO.setCurrentCategoryName(thirdCategory.getCategoryName());
            searchPageCategoryVO.setSecondLevelCategoryName(secondCategory.getCategoryName());
            searchPageCategoryVO.setThirdLevelCategoryList(thirdCateGoryList);
            request.setAttribute("goodsCategoryId", goodsCategoryId);
            request.setAttribute("searchPageCategoryVO", searchPageCategoryVO);
        }
        return "mall/search";
    }

    @GetMapping("/goods/detail/{goodsId}")
    public String detail(@PathVariable("goodsId") Long goodsId) {
        request.setAttribute("goodsDetail", goodsInfoService.getById(goodsId));
        return "mall/detail";
    }
}
