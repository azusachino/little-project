package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Product;
import cn.az.project.shop.db.mapper.ProductMapper;
import cn.az.project.shop.db.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
