package cn.az.replica.mall.service;

import cn.az.replica.mall.controller.vo.GoodsCategoryVo;
import cn.az.replica.mall.entity.GoodsCategory;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * The interface Goods category service.
 *
 * @author az
 */
public interface IGoodsCategoryService extends IService<GoodsCategory> {

    /**
     * Select page page.
     *
     * @param page the page
     * @return the page
     */
    IPage<GoodsCategory> selectPage(Page<GoodsCategory> page);

    /**
     * Tree list list.
     *
     * @return the list
     */
    List<GoodsCategoryVo> treeList();
}
