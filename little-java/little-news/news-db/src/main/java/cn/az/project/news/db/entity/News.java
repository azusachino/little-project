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
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新闻主键id
     */
    @TableId(value = "NEWS_ID", type = IdType.AUTO)
    private Long newsId;

    /**
     * 标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 新闻类型
     */
    @TableField("CATEGORY_ID")
    private Long categoryId;

    /**
     * 新闻封面图片
     */
    @TableField("COVER_IMAGE")
    private String coverImage;

    /**
     * 内容
     */
    @TableField("CONTENT")
    private String content;

    /**
     * 发布状态 0-发布 1-草稿
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 浏览量
     */
    @TableField("VIEWS")
    private Long views;

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

    /**
     * 修改时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;


}
