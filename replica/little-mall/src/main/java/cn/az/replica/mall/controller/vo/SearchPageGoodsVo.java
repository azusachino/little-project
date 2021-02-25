package cn.az.replica.mall.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author az
 * @since 2020-03-25
 */
@Data
public class SearchPageGoodsVo implements Serializable {

    private static final long serialVersionUID = -7128387798483449930L;

    private Long goodsId;

    private String goodsName;

    private String goodsIntro;

    private String goodsCoverImg;

    private Integer sellingPrice;
}
