package cn.az.replica.mall.service.impl;

import cn.az.replica.mall.controller.vo.SearchPageGoodsVo;
import cn.az.replica.mall.controller.vo.SearchParameterVo;
import cn.az.replica.mall.entity.GoodsInfo;
import cn.az.replica.mall.mapper.GoodsInfoMapper;
import cn.az.replica.mall.service.IGoodsInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author az
 */
@Service
public class GoodsInfoServiceImpl extends ServiceImpl<GoodsInfoMapper, GoodsInfo> implements IGoodsInfoService {

    /**
     * Select page page.
     *
     * @param page the page
     * @return the page
     */
    @Override
    public IPage<GoodsInfo> selectPage(Page<GoodsInfo> page) {
        return null;
    }

    /**
     * Search goods list page.
     *
     * @param page the page
     * @param vo   the vo
     * @return the page
     */
    @Override
    public IPage<SearchPageGoodsVo> searchGoodsList(Page<SearchPageGoodsVo> page, SearchParameterVo vo) {
        return null;
    }
}
