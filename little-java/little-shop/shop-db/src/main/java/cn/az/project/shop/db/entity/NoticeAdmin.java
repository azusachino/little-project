package cn.az.project.shop.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 通知管理员表
 *
 * @author Liz
 */
@Data
@TableName("tb_notice_admin")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class NoticeAdmin implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 通知ID
     */
    private Integer noticeId;

    /**
     * 通知标题
     */
    private String noticeTitle;

    /**
     * 接收通知的管理员ID
     */
    private Integer adminId;

    /**
     * 阅读时间，如果是NULL则是未读状态
     */
    private LocalDateTime readTime;

    /**
     * 创建时间
     */
    private LocalDateTime addTime;

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
