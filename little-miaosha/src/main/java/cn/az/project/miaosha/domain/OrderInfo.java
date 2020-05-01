package cn.az.project.miaosha.domain;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author az
 * @date 2020/4/23
 */
@Data
@ToString
public class OrderInfo {
    private Long id;
    private Long userId;
    private Long goodsId;
    private Long deliveryAddrId;
    private String goodsName;
    private Integer goodsCount;
    private BigDecimal goodsPrice;
    private Integer orderChannel;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime payDate;
}
