package cn.az.project.muxin.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Message action enum.
 *
 * @author az
 * @since 2020 -03-27
 */
@Getter
@AllArgsConstructor
public enum MessageActionEnum implements IEnum<Integer> {
    /**
     * Connect message action enum.
     */
    CONNECT(1, "第一次(或重连)初始化连接"),
    /**
     * Chat message action enum.
     */
    CHAT(2, "聊天消息"),
    /**
     * Signed message action enum.
     */
    SIGNED(3, "消息签收"),
    /**
     * Keepalive message action enum.
     */
    KEEP_ALIVE(4, "客户端保持心跳"),
    /**
     * Pull friend message action enum.
     */
    PULL_FRIEND(5, "拉取好友");

    private Integer type;
    private String value;

    /**
     * 枚举数据库存储值
     */
    @Override
    public Integer getValue() {
        return type;
    }

}
