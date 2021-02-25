package cn.az.project.muxin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * @author az
 */
@Getter
@AllArgsConstructor
public enum MessageAction {
    /**
     * 第一次(或重连)初始化连接
     */
    CONNECT(1, "第一次(或重连)初始化连接"),
    /**
     * 聊天消息
     */
    CHAT(2, "聊天消息"),
    /**
     * 消息签收
     */
    SIGNED(3, "消息签收"),
    /**
     * 客户端保持心跳
     */
    KEEP_ALIVE(4, "客户端保持心跳"),
    /**
     * 拉取好友
     */
    PULL_FRIEND(5, "拉取好友");

    public final Integer action;
    public final String content;

    public Optional<String> of(Integer action) {
        for (MessageAction messageAction : values()) {
            if (messageAction.getAction().equals(action)) {
                return Optional.of(messageAction.getContent());
            }
        }
        return Optional.empty();
    }
}
