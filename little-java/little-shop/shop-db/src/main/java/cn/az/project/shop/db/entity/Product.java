package cn.az.project.shop.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品基本信息表
 *
 * @author Liz
 */
@Data
@TableName("tb_product")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Product implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品编号
     */
    private String productSn;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品所属类目ID
     */
    private Integer categoryId;

    private Integer brandId;

    /**
     * 商品宣传图片列表，采用JSON数组格式
     */
    private String gallery;

    /**
     * 商品关键字，采用逗号间隔
     */
    private String keywords;

    /**
     * 商品简介
     */
    private String brief;

    /**
     * 是否上架
     */
    private Boolean isOnSale;

    private Integer sortOrder;

    /**
     * 商品页面商品图片
     */
    private String picUrl;

    /**
     * 商品分享朋友圈图片
     */
    private String shareUrl;

    /**
     * 是否新品首发，如果设置则可以在新品首发页面展示
     */
    private Boolean isNew;

    /**
     * 是否人气推荐，如果设置则可以在人气推荐页面展示
     */
    private Boolean isHot;

    /**
     * 商品单位，例如件、盒
     */
    private String unit;

    /**
     * 专柜价格
     */
    private BigDecimal counterPrice;

    /**
     * 零售价格
     */
    private BigDecimal retailPrice;

    /**
     * 商品详细介绍，是富文本格式
     */
    private String detail;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean deleted;


}
