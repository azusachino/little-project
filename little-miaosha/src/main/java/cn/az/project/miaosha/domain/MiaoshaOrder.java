package cn.az.project.miaosha.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author az
 * @date 2020/4/23
 */
@Data
@ToString
public class MiaoshaOrder {

    private Long id;
    private Long userId;
    private Long orderId;
    private Long goodsId;
}
