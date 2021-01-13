package cn.az.project.muxin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author az
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Chat implements Serializable {

    private static final long serialVersionUID = 2983513029336088998L;

    @TableId
    private String id;

    private String senderId;

    private String receiverId;

    private String message;

    /**
     * 消息是否签收状态
     * 1：签收
     * 0：未签收
     */
    private Integer signFlag;

    /**
     * 发送请求的事件
     */
    private LocalDateTime createTime;
}
