package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Order;
import cn.az.project.shop.db.mapper.OrderMapper;
import cn.az.project.shop.db.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
