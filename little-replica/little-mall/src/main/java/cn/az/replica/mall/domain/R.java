package cn.az.replica.mall.domain;

import org.springframework.http.HttpStatus;

/**
 * R
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @since 2020-03-24
 */
public class R<T> {

    private Integer code;
    private String msg;
    private T data;

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> success() {
        return success(null);
    }

    public static <T> R<T> success(T data) {
        return success("请求成功", data);
    }

    public static <T> R<T> success(String msg, T data) {
        return success(HttpStatus.OK, msg, data);
    }

    public static <T> R<T> success(HttpStatus status, String msg, T data) {
        return new R<>(status.value(), msg, data);
    }

    public static <T> R<T> fail() {
        return fail(null);
    }

    public static <T> R<T> fail(T data) {
        return fail("请求失败", data);
    }

    public static <T> R<T> fail(String msg, T data) {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR, msg, data);
    }

    public static <T> R<T> fail(HttpStatus status, String msg, T data) {
        return new R<>(status.value(), msg, data);
    }

}
