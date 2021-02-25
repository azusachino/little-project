package cn.az.project.muxin.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author az
 * @since 2020-03-27
 */
@Data
public class ChatMessage implements Serializable {

    private static final long serialVersionUID = -7082968272964348251L;

    /**
     * 发送者的用户id
     */
    private String senderId;
    /**
     * 接受者的用户id
     */
    private String receiverId;
    /**
     * 聊天内容
     */
    private String msg;
    /**
     * 用于消息的签收
     */
    private String msgId;
}
