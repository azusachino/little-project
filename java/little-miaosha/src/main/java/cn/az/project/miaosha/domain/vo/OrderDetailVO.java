package cn.az.project.miaosha.domain.vo;

import cn.az.project.miaosha.domain.OrderInfo;
import lombok.Data;
import lombok.ToString;

/**
 * @author az
 */
@Data
@ToString
public class OrderDetailVO {

    private GoodsVO goods;
    private OrderInfo order;
}
