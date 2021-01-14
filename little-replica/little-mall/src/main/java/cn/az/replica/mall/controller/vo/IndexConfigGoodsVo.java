package cn.az.replica.mall.controller.vo;

import lombok.Data;

/**
 * @author az
 * @since 2020-03-25
 */
@Data
public class IndexConfigGoodsVo {

    private Long goodsId;

    private String goodsName;

    private String goodsIntro;

    private String goodsCoverImg;

    private Integer sellingPrice;

    private String tag;

}
