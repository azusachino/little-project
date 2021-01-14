package cn.az.replica.mall.service;

import cn.az.replica.mall.entity.Carousel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * The interface Carousel service.
 *
 * @author az
 */
public interface ICarouselService extends IService<Carousel> {

    /**
     * Select page page.
     *
     * @param page     the page
     * @return the page
     */
    IPage<Carousel> selectPage(Page<Carousel> page);
}
