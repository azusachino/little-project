package cn.az.replica.mall.controller.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author az
 * @since 2020-03-25
 */
@Data
public class OrderDetailVo {

    private String orderNo;

    private Double totalPrice;

    private Integer payStatus;

    private String payStatusString;

    private Integer payType;

    private String payTypeString;

    private LocalDateTime payTime;

    private Integer orderStatus;

    private String orderStatusString;

    private String userAddress;

    private LocalDateTime createTime;

    private List<OrderItemVo> orderItems;

}
