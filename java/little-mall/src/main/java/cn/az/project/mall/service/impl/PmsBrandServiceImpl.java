package cn.az.project.mall.service.impl;

import cn.az.project.mall.entity.PmsBrand;
import cn.az.project.mall.mapper.PmsBrandMapper;
import cn.az.project.mall.service.IPmsBrandService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AzusaChino
 * @version 2019-12-12
 */
@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements IPmsBrandService {

    /**
     * List all brand list.
     *
     * @return the list
     */
    @Override
    public List<PmsBrand> listAllBrand() {
        return list();
    }

    /**
     * Create brand int.
     *
     * @param brand the brand
     * @return the int
     */
    @Override
    public int createBrand(PmsBrand brand) {
        if (save(brand)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Update brand int.
     *
     * @param id    the id
     * @param brand the brand
     * @return the int
     */
    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        if (saveOrUpdate(brand)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Delete brand int.
     *
     * @param id the id
     * @return the int
     */
    @Override
    public int deleteBrand(Long id) {
        if (removeById(id)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * List brand list.
     *
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the list
     */
    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        Page<PmsBrand> page = new Page<>(pageNum, pageSize);
        return baseMapper.selectPage(page, Wrappers.emptyWrapper()).getRecords();
    }

    /**
     * Gets brand.
     *
     * @param id the id
     * @return the brand
     */
    @Override
    public PmsBrand getBrand(Long id) {
        return getById(id);
    }
}
