package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.OrderProduct;
import cn.az.project.shop.db.mapper.OrderProductMapper;
import cn.az.project.shop.db.service.IOrderProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class OrderProductServiceImpl extends ServiceImpl<OrderProductMapper, OrderProduct> implements IOrderProductService {

}
