package cn.az.project.test.common.error;

import lombok.Data;

/**
 * @author Liz
 **/
@Data
public class CommonError {

    private int code;
    private String message;

    CommonError(ErrorCode errorCode) {
        this.code = errorCode.code;
        this.message = errorCode.message;
    }

    public void setCode(ErrorCode errorCode) {
        this.code = errorCode.code;
    }

    public void setMessage(ErrorCode errorCode) {
        this.message = errorCode.message;
    }
}
