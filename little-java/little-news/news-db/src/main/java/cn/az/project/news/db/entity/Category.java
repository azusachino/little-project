package cn.az.project.news.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Liz
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类别主键id
     */
    @TableId(value = "CATEGORY_ID", type = IdType.AUTO)
    private Long categoryId;

    /**
     * 类别名称
     */
    @TableField("CATEGORY_NAME")
    private String categoryName;

    /**
     * 是否已删除 0-未删除 1-已删除
     */
    @TableField("IS_DELETED")
    @TableLogic(delval = "1", value = "0")
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

}
