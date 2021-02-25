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
public class FriendRequest implements Serializable {

    private static final long serialVersionUID = 5774947545642211284L;

    @TableId
    private String id;

    private String senderId;

    private String receiverId;

    /**
     * 发送请求的事件
     */
    private LocalDateTime requestDateTime;
}
