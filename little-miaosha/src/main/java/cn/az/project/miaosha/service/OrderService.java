package cn.az.project.miaosha.service;

import cn.az.project.miaosha.domain.MiaoshaOrder;
import cn.az.project.miaosha.domain.MiaoshaUser;
import cn.az.project.miaosha.domain.OrderInfo;
import cn.az.project.miaosha.domain.vo.GoodsVO;

/**
 * @author az
 * @date 2020/4/24
 */
public interface OrderService {

    MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long userId, long goodsId);

    OrderInfo getOrderById(long id);

    OrderInfo createOrder(MiaoshaUser mu, GoodsVO vo);

    void deleteOrders();
}
