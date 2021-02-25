package cn.az.project.test.common.error;

/**
 * The enum Error code.
 *
 * @author Liz
 */
public enum ErrorCode {

    /**
     * Unknown error code.
     */
    UNKNOWN(101, "Unknown error happened"),
    /**
     * Un auth error code.
     */
    UN_AUTH(102, "You are not authorized, please login"),
    /**
     * Parameter error code.
     */
    PARAMETER(201, "Parameter seems to be incorrect");

    /**
     * The Code.
     */
    int code;
    String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
