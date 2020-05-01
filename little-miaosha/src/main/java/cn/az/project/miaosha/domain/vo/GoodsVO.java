package cn.az.project.miaosha.domain.vo;

import cn.az.project.miaosha.domain.Goods;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author az
 * @date 2020/4/23
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class GoodsVO extends Goods {

    private BigDecimal miaoshaPrice;
    private Integer stockCount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
