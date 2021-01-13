package cn.az.project.mall.service.impl;

import cn.az.project.mall.dao.EsProductDao;
import cn.az.project.mall.nosql.es.document.EsProduct;
import cn.az.project.mall.nosql.es.repository.EsProductRepository;
import cn.az.project.mall.service.IEsProductService;
import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Liz
 */
@Slf4j
@Service
public class EsProductServiceImpl implements IEsProductService {

    @Resource
    private EsProductRepository productRepository;

    @Resource
    private EsProductDao productDao;

    /**
     * 从数据库中导入所有商品到ES
     *
     * @return the int
     */
    @Override
    public int importAll() {
        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
        Iterator<EsProduct> iterator = productRepository.saveAll(esProductList).iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    /**
     * 根据id删除商品
     *
     * @param id the id
     */
    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * 根据id创建商品
     *
     * @param id the id
     * @return the es product
     */
    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> esProductList = productDao.getAllEsProductList(id);
        if (esProductList.size() > 0) {
            EsProduct esProduct = esProductList.get(0);
            result = productRepository.save(esProduct);
        }
        return result;
    }

    /**
     * 批量删除商品
     *
     * @param ids the ids
     */
    @Override
    public void delete(List<Long> ids) {
        if (CollUtil.isNotEmpty(ids)) {
            List<EsProduct> esProductList = new ArrayList<>();
            for (Long id : ids) {
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                esProductList.add(esProduct);
            }
            productRepository.deleteAll(esProductList);
        }
    }

    /**
     * 根据关键字搜索名称或者副标题
     *
     * @param keyword  the keyword
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the page
     */
    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return productRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, pageable);

    }
}
