package cn.az.replica.mall.controller.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author az
 * @since 2020-03-25
 */
@Data
public class OrderListVo {

    private Long orderId;

    private String orderNo;

    private Integer totalPrice;

    private Integer payType;

    private Integer orderStatus;

    private String orderStatusString;

    private String userAddress;

    private LocalDateTime createTime;

    private List<OrderItemVo> orderItems;
}
