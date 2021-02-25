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
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论主键id
     */
    @TableId(value = "COMMENT_ID", type = IdType.AUTO)
    private Long commentId;

    /**
     * 关联咨询主键id
     */
    @TableField("NEWS_ID")
    private Long newsId;

    /**
     * 评论人
     */
    @TableField("USER_ID")
    private String userId;

    /**
     * 评论内容
     */
    @TableField("CONTENT")
    private String content;

    /**
     * 评论状态 0-未审核 1-审核通过
     */
    @TableField("STATUS")
    private Integer status;

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
