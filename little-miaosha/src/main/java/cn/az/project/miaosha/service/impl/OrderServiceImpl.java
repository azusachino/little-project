package cn.az.project.miaosha.service.impl;

import cn.az.project.miaosha.constant.OrderKey;
import cn.az.project.miaosha.dao.OrderDao;
import cn.az.project.miaosha.domain.MiaoshaOrder;
import cn.az.project.miaosha.domain.MiaoshaUser;
import cn.az.project.miaosha.domain.OrderInfo;
import cn.az.project.miaosha.domain.vo.GoodsVO;
import cn.az.project.miaosha.service.OrderService;
import cn.az.project.miaosha.service.RedisService;
import cn.az.project.miaosha.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author az
 * @date 2020/4/24
 */
@Service
public class OrderServiceImpl implements OrderService {

    OrderDao orderDao;
    RedisService redisService;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long userId, long goodsId) {
        return BeanUtil.toBean(redisService.get(OrderKey.getMiaoshaOrderByUidGid() + String.valueOf(userId) + "_" + goodsId), MiaoshaOrder.class).orElse(null);
    }

    @Override
    public OrderInfo getOrderById(long id) {
        return orderDao.getOrderById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public OrderInfo createOrder(MiaoshaUser mu, GoodsVO vo) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateDate(LocalDateTime.now());
        orderInfo.setDeliveryAddrId(0L);
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsId(vo.getId());
        orderInfo.setGoodsName(vo.getGoodsName());
        orderInfo.setGoodsPrice(vo.getMiaoshaPrice());
        orderInfo.setOrderChannel(1);
        orderInfo.setStatus(0);
        orderInfo.setUserId(mu.getId());
        long result = orderDao.insert(orderInfo);
        if (result > 0) {
            MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
            miaoshaOrder.setGoodsId(vo.getId());
            miaoshaOrder.setOrderId(orderInfo.getId());
            miaoshaOrder.setUserId(mu.getId());
            result = orderDao.insertMiaoshaOrder(miaoshaOrder);
            if (result > 0) {
                redisService.set(OrderKey.getMiaoshaOrderByUidGid() + String.valueOf(mu.getId()) + "_" + vo.getId(), BeanUtil.toString(miaoshaOrder).orElse(""));
            }
        }
        return orderInfo;
    }

    @Override
    public void deleteOrders() {
        orderDao.truncateOrders();
        orderDao.truncateMiaoshaOrders();

    }
}
