package cn.az.project.miaosha.domain.vo;

import cn.az.project.miaosha.domain.OrderInfo;
import lombok.Data;
import lombok.ToString;

/**
 * @author az
 * @date 2020/4/23
 */
@Data
@ToString
public class OrderDetailVO {

    private GoodsVO goods;
    private OrderInfo order;
}
