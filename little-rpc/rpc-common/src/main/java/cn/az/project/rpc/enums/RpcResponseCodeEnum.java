package cn.az.project.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author az
 * @since 12/09/20 23:13
 */
@AllArgsConstructor
@Getter
@ToString
public enum RpcResponseCodeEnum {

    /**
     * Success
     */
    SUCCESS(200, "The remote call is successful"),
    /**
     * failed
     */
    FAIL(500, "The remote call is fail");

    private final int code;
    private final String message;

}