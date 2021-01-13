package cn.az.project.mall.service;

import cn.az.project.mall.entity.PmsBrand;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * The interface Pms brand service.
 *
 * @author AzusaChino
 * @version 2019 -12-12
 */
public interface IPmsBrandService extends IService<PmsBrand> {

    /**
     * List all brand list.
     *
     * @return the list
     */
    List<PmsBrand> listAllBrand();

    /**
     * Create brand int.
     *
     * @param brand the brand
     * @return the int
     */
    int createBrand(PmsBrand brand);

    /**
     * Update brand int.
     *
     * @param id    the id
     * @param brand the brand
     * @return the int
     */
    int updateBrand(Long id, PmsBrand brand);

    /**
     * Delete brand int.
     *
     * @param id the id
     * @return the int
     */
    int deleteBrand(Long id);

    /**
     * List brand list.
     *
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the list
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     * Gets brand.
     *
     * @param id the id
     * @return the brand
     */
    PmsBrand getBrand(Long id);
}
