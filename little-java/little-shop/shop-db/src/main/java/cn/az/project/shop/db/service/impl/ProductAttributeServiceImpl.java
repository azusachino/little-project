package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.ProductAttribute;
import cn.az.project.shop.db.mapper.ProductAttributeMapper;
import cn.az.project.shop.db.service.IProductAttributeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeMapper, ProductAttribute> implements IProductAttributeService {

}
