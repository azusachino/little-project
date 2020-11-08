package cn.az.project.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author az
 * @since 11/08/20
 */
@Getter
@AllArgsConstructor
public enum CompressTypeEnum {

    GZIP((byte) 0x01, "gzip");

    private final byte code;
    private final String name;

    public static String getName(byte code) {
        for (CompressTypeEnum c : CompressTypeEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

}
