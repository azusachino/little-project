package cn.az.card.merchant.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author az
 * @date 2020/3/17
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
    /**
     * success
     */
    SUCCESS(0, "success"),
    /**
     * DUPLICATE_NAME
     */
    DUPLICATE_NAME(1, "duplicate merchant name"),
    /**
     * EMPTY_LOGO
     */
    EMPTY_LOGO(2, "no logo for merchant"),
    /**
     * EMPTY_BUSINESS_LICENSE
     */
    EMPTY_BUSINESS_LICENSE(3, "no license for merchant"),
    /**
     * ERROR_PHONE
     */
    ERROR_PHONE(4, "wrong phone"),

    /**
     * EMPTY_ADDRESS
     */
    EMPTY_ADDRESS(5, "no address for merchant"),
    /**
     * MERCHANT_NOT_EXIST
     */
    MERCHANT_NOT_EXIST(6, "no merchant"),
    ;

    private Integer code;
    private String description;
}
