package cn.az.project.miaosha.result;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

/**
 * @author az
 * @since 2020-04-13
 */
@Data
@NoArgsConstructor
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    private Result(@NonNull CodeMessage cm, T t) {
        this.code = cm.getCode();
        this.message = cm.getMessage();
        this.data = t;
    }

    /**
     * 成功时候的调用
     */
    public static <T> Result<T> success(T data) {
        return success(CodeMessage.SUCCESS, data);
    }

    public static <T> Result<T> success(CodeMessage cm, T data) {
        return new Result<>(cm, data);
    }

    /**
     * 失败时候的调用
     */
    public static <T> Result<T> error(CodeMessage codeMsg) {
        return error(codeMsg, null);
    }

    /**
     * 失败时候的调用
     */
    public static <T> Result<T> error(CodeMessage codeMsg, T data) {
        return new Result<>(codeMsg, data);
    }
}
