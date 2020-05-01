package cn.az.project.miaosha.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * The enum Code message.
 *
 * @author az
 * @since 2020-04-13
 */
@Getter
@AllArgsConstructor
public enum CodeMessage {

    /**
     * Success code message.
     */
    SUCCESS(0, "success"),
    /**
     * Server error code message.
     */
    SERVER_ERROR(500100, "服务端异常"),
    /**
     * Bind error code message.
     */
    BIND_ERROR(500101, "参数校验异常"),

    REQUEST_ILLEGAL(500102, "请求非法"),

    ACCESS_LIMIT_REACHED(500104, "访问太频繁！"),
    /**
     * Session error code message.
     */
    SESSION_ERROR(500210, "Session不存在或者已经失效"),
    /**
     * Password empty code message.
     */
    PASSWORD_EMPTY(500211, "登录密码不能为空"),
    /**
     * Mobile empty code message.
     */
    MOBILE_EMPTY(500212, "手机号不能为空"),
    /**
     * Mobile error code message.
     */
    MOBILE_ERROR(500213, "手机号格式错误"),
    /**
     * Mobile not exist code message.
     */
    MOBILE_NOT_EXIST(500214, "手机号不存在"),
    /**
     * Password error code message.
     */
    PASSWORD_ERROR(500215, "密码错误"),

    //订单模块 5004XX
    ORDER_NOT_EXIST(500400, "订单不存在"),

    //秒杀模块 5005XX
    MIAOSHA_OVER(500500, "商品已经秒杀完毕"),
    MIAOSHA_AGAIN(500501, "不能重复秒杀"),
    MIAOSHA_FAIL(500502, "秒杀失败");

    private final Integer code;
    private final String message;

    public static Optional<String> of(int code) {
        for (CodeMessage cm : values()) {
            if (cm.getCode().equals(code)) {
                return Optional.of(cm.getMessage());
            }
        }
        return Optional.empty();
    }

}
