package cn.az.project.miaosha.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author az
 */
@Data
public class MiaoshaUser {

    private Long id;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private LocalDateTime registerDate;
    private LocalDateTime lastLoginDate;
    private Integer loginCount;
}
