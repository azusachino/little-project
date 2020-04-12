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
public enum FriendRequestStatus {

    /**
     * 拒绝
     */
    REJECT(0, "拒绝"),
    /**
     * 忽略
     */
    IGNORE(1, "忽略"),
    /**
     * 通过
     */
    APPROVE(2, "通过");

    public final Integer status;
    public final String message;

    public Optional<String> of(Integer status) {
        for (FriendRequestStatus requestStatus : values()) {
            if (requestStatus.getStatus().equals(status)) {
                return Optional.of(requestStatus.getMessage());
            }
        }
        return Optional.empty();
    }
}
