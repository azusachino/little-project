package cn.az.project.muxin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author az
 * @date 2020/4/10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private HttpStatus status;
    private String message;
    private T data;

    public static <T> Response<T> ok() {
        return ok(HttpStatus.OK);
    }

    public static <T> Response<T> ok(HttpStatus status) {
        return ok(status, status.getReasonPhrase());
    }

    public static <T> Response<T> ok(HttpStatus status, String message) {
        return ok(status, message, null);
    }

    public static <T> Response<T> ok(HttpStatus status, String message, T t) {
        return Response.<T>builder().data(t).status(status).message(message).build();
    }

    public static <T> Response<T> error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> Response<T> error(HttpStatus status) {
        return error(status, status.getReasonPhrase());
    }

    public static <T> Response<T> error(HttpStatus status, String message) {
        return error(status, message, null);
    }

    public static <T> Response<T> error(HttpStatus status, String message, T t) {
        return Response.<T>builder().data(t).status(status).message(message).build();
    }
}
