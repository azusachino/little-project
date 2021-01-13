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
 * 专题表
 *
 * @author Liz
 */
@Data
@TableName("tb_topic")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Topic implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 专题标题
     */
    private String title;

    /**
     * 专题子标题
     */
    private String subtitle;

    /**
     * 专题内容，富文本格式
     */
    private String content;

    /**
     * 专题相关商品最低价
     */
    private BigDecimal price;

    /**
     * 专题阅读量
     */
    private String readCount;

    /**
     * 专题图片
     */
    private String picUrl;

    /**
     * 排序
     */
    private Integer sortOrder;

    /**
     * 专题相关商品，采用JSON数组格式
     */
    private String product;

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
