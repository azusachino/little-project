package cn.az.project.miaosha.domain;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author az
 * @date 2020/4/23
 */
@Data
@ToString
public class MiaoshaGoods {

    private Long id;
    private Long goodsId;
    private Integer stockCount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
