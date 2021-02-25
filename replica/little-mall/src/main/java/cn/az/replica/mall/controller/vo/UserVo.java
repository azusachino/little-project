package cn.az.replica.mall.controller.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author az
 * @since 2020-03-25
 */
@Data
public class UserVo {
    private Long userId;

    private String nickName;

    private String loginName;

    private String password;

    private String introduceSign;

    private String address;

    private Integer shopCartItemCount;

    private Integer isDeleted;

    private Integer lockedFlag;

    private LocalDateTime createTime;
}
