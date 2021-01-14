package cn.az.replica.mall.controller.vo;

import lombok.Data;

import java.util.List;

/**
 * @author az
 * @since 2020-03-25
 */
@Data
public class GoodsCategoryVo {

    private Long categoryId;

    private Long parentId;

    private Byte categoryLevel;

    private String categoryName;

    private List<GoodsCategoryVo> subCategories;
}
