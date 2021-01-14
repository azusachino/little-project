package cn.az.replica.mall.service.impl;

import cn.az.replica.mall.entity.Carousel;
import cn.az.replica.mall.mapper.CarouselMapper;
import cn.az.replica.mall.service.ICarouselService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author az
 */
@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements ICarouselService {

    @Override
    public IPage<Carousel> selectPage(Page<Carousel> page) {
        return baseMapper.selectPage(page, Wrappers.emptyWrapper());
    }
}
