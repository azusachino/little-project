package cn.az.project.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 品牌表
 *
 * @author AzusaChino
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmsBrand implements Serializable {

    private static final long serialVersionUID = 7957551956700682245L;

    @TableId(value = "id")
    private Long id;

    private String name;

    /**
     * 首字母
     */
    @ApiModelProperty(value = "首字母")
    private String firstLetter;

    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    @ApiModelProperty(value = "是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;

    private Integer showStatus;

    /**
     * 产品数量
     */
    @ApiModelProperty(value = "产品数量")
    private Integer productCount;

    /**
     * 产品评论数量
     */
    @ApiModelProperty(value = "产品评论数量")
    private Integer productCommentCount;

    /**
     * 品牌logo
     */
    @ApiModelProperty(value = "品牌logo")
    private String logo;

    /**
     * 专区大图
     */
    @ApiModelProperty(value = "专区大图")
    private String bigPic;

    /**
     * 品牌故事
     */
    @ApiModelProperty(value = "品牌故事")
    private String brandStory;

}
