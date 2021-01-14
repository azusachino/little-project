package cn.az.replica.mall.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * PayType
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see IEnum
 * @since 2020 -03-24
 */
@Getter
@AllArgsConstructor
public enum PayType implements IEnum<Integer> {
    /**
     * Default pay type.
     */
    DEFAULT(-1, "ERROR"),
    /**
     * Not pay pay type.
     */
    NOT_PAY(0, "无"),
    /**
     * Ali pay pay type.
     */
    ALI_PAY(1, "支付宝"),
    /**
     * Wechat pay pay type.
     */
    WECHAT_PAY(2, "微信支付");

    private Integer type;
    private String name;

    /**
     * 枚举数据库存储值
     */
    @Override
    public Integer getValue() {
        return type;
    }

    public static PayType of(int type) {
        for (PayType p : values()) {
            if (p.getType() == type) {
                return p;
            }
        }
        return DEFAULT;
    }
}
