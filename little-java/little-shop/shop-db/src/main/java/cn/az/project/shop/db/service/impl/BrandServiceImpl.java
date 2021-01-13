package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Brand;
import cn.az.project.shop.db.mapper.BrandMapper;
import cn.az.project.shop.db.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

}
