package cn.az.project.mall.service;

import cn.az.project.mall.nosql.es.document.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * The interface Es product service.
 *
 * @author Liz
 */
public interface IEsProductService {

    /**
     * 从数据库中导入所有商品到ES
     *
     * @return the int
     */
    int importAll();

    /**
     * 根据id删除商品
     *
     * @param id the id
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     *
     * @param id the id
     * @return the es product
     */
    EsProduct create(Long id);

    /**
     * 批量删除商品
     *
     * @param ids the ids
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索名称或者副标题
     *
     * @param keyword  the keyword
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the page
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);

}
