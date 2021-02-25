package cn.az.project.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author az
 * @since 11/08/20
 */
@Getter
@AllArgsConstructor
public enum SerializationTypeEnum {

    KYRO((byte) 0x01, "kyro"),
    PROTOSTUFF((byte) 0x02, "protostuff");

    private final byte code;
    private final String name;

    public static String getName(byte code) {
        for (SerializationTypeEnum c : SerializationTypeEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

}