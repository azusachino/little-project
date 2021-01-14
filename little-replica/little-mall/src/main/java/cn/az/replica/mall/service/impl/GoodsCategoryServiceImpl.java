package cn.az.replica.mall.service.impl;

import cn.az.replica.mall.controller.vo.GoodsCategoryVo;
import cn.az.replica.mall.entity.GoodsCategory;
import cn.az.replica.mall.mapper.GoodsCategoryMapper;
import cn.az.replica.mall.service.IGoodsCategoryService;
import cn.az.replica.mall.util.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 */
@Service
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryMapper, GoodsCategory> implements IGoodsCategoryService {

    @Override
    public IPage<GoodsCategory> selectPage(Page<GoodsCategory> page) {
        return baseMapper.selectPage(page, Wrappers.emptyWrapper());
    }

    /**
     * Tree list list.
     *
     * @return the list
     */
    @Override
    public List<GoodsCategoryVo> treeList() {
        List<GoodsCategoryVo> voList = BeanUtil.copyList(list(), GoodsCategoryVo.class);
        List<GoodsCategoryVo> root = new ArrayList<>();
        voList.forEach(vo -> {
            if (vo.getParentId() == 0) {
                root.add(vo);
            }
            List<GoodsCategoryVo> child = new ArrayList<>();
            voList.forEach(o -> {
                if (o.getParentId().equals(vo.getCategoryId())) {
                    child.add(o);
                    vo.setSubCategories(child);
                }
            });
        });
        return root;
    }
}
