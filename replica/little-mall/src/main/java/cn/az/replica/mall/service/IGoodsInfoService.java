package cn.az.replica.mall.service;

import cn.az.replica.mall.controller.vo.SearchPageGoodsVo;
import cn.az.replica.mall.controller.vo.SearchParameterVo;
import cn.az.replica.mall.entity.GoodsInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * The interface Goods info service.
 *
 * @author az
 */
public interface IGoodsInfoService extends IService<GoodsInfo> {

    /**
     * Select page page.
     *
     * @param page the page
     * @return the page
     */
    IPage<GoodsInfo> selectPage(Page<GoodsInfo> page);

    /**
     * Search goods list page.
     *
     * @param page the page
     * @param vo   the vo
     * @return the page
     */
    IPage<SearchPageGoodsVo> searchGoodsList(Page<SearchPageGoodsVo> page, SearchParameterVo vo);
}
