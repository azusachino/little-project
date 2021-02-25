package cn.az.replica.mall.service.impl;

import cn.az.replica.mall.entity.OrderItem;
import cn.az.replica.mall.mapper.OrderItemMapper;
import cn.az.replica.mall.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author az
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

}
