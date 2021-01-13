package cn.az.project.muxin.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Friend status enum.
 *
 * @author az
 * @since 2020 -03-27
 */
@Getter
@AllArgsConstructor
public enum FriendStatusEnum implements IEnum<Integer> {

    /**
     * Success friend status enum.
     */
    SUCCESS(0, "OK"),
    /**
     * User not exist friend status enum.
     */
    USER_NOT_EXIST(1, "无此用户..."),
    /**
     * Not yourself friend status enum.
     */
    YOURSELF(2, "不能添加你自己..."),
    /**
     * Already friend friend status enum.
     */
    ALREADY_FRIEND(3, "该用户已经是你的好友...");

    /**
     * The Status.
     */
    public Integer status;
    /**
     * The Msg.
     */
    public String msg;

    /**
     * 枚举数据库存储值
     */
    @Override
    public Integer getValue() {
        return status;
    }
}
