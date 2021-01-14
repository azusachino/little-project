package cn.az.replica.mall.controller.vo;

import lombok.Data;

/**
 * @author az
 * @since 2020-03-25
 */
@Data
public class ShopCartVo {

    private Long cartItemId;

    private Long goodsId;

    private Integer goodsCount;

    private String goodsName;

    private String goodsCoverImg;

    private Integer sellingPrice;
}
