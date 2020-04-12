package cn.az.project.muxin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * @author az
 * @date 2020/4/10
 */
@Getter
@AllArgsConstructor
public enum SearchFriendStatus {

    /**
     * OK
     */
    SUCCESS(0, "OK"),
    /**
     * 无此用户
     */
    USER_NOT_EXIST(1, "无此用户..."),
    /**
     * 不能添加你自己
     */
    NOT_YOURSELF(2, "不能添加你自己..."),
    /**
     * 该用户已经是你的好友
     */
    ALREADY_FRIEND(3, "该用户已经是你的好友...");

    public final Integer status;
    public final String message;

    public static Optional<String> of(Integer status) {
        for (SearchFriendStatus friendStatus : values()) {
            if (status.equals(friendStatus.status)) {
                return Optional.of(friendStatus.message);
            }
        }
        return Optional.empty();
    }
}
