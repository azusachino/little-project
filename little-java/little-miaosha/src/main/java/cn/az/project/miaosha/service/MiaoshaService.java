package cn.az.project.miaosha.service;

import cn.az.project.miaosha.domain.MiaoshaUser;
import cn.az.project.miaosha.domain.OrderInfo;
import cn.az.project.miaosha.domain.vo.GoodsVO;

/**
 * @author az
 */
public interface MiaoshaService {

    OrderInfo miaosha(MiaoshaUser mu, GoodsVO vo);

    long getMiaoshaResult(long userId, long goodsId);
}
