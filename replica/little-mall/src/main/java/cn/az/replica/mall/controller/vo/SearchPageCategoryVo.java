package cn.az.replica.mall.controller.vo;

import cn.az.replica.mall.entity.GoodsCategory;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author az
 * @since 2020-03-25
 */
@Data
public class SearchPageCategoryVo implements Serializable {

    private static final long serialVersionUID = -1177242859194719682L;

    private String firstLevelCategoryName;

    private List<GoodsCategory> secondLevelCategoryList;

    private String secondLevelCategoryName;

    private List<GoodsCategory> thirdLevelCategoryList;

    private String currentCategoryName;


}
