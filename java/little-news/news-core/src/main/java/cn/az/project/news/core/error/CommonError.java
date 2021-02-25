package cn.az.project.news.core.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author : Liz
 **/
@Data
public class CommonError {

    private int code;
    private String message;

    CommonError(HttpStatus status) {
        this.code = status.value();
        this.message = status.getReasonPhrase();
    }

    public void setCode(HttpStatus status) {
        this.code = status.value();
    }

    public void setMessage(HttpStatus status) {
        this.message = status.getReasonPhrase();
    }
}
