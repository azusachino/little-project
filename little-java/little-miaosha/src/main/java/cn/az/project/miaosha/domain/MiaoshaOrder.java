package cn.az.project.miaosha.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author az
 */
@Data
@ToString
public class MiaoshaOrder {

    private Long id;
    private Long userId;
    private Long orderId;
    private Long goodsId;
}
