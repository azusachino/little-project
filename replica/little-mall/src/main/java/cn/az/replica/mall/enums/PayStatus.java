package cn.az.replica.mall.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * PayStatus
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see IEnum
 * @since 2020 -03-24
 */
@Getter
@AllArgsConstructor
public enum PayStatus implements IEnum<Integer> {
    /**
     * Default pay status.
     */
    DEFAULT(-1, "支付失败"),
    /**
     * Pay ing pay status.
     */
    PAY_ING(0, "支付中"),
    /**
     * Pay success pay status.
     */
    PAY_SUCCESS(1, "支付成功");

    private Integer status;

    private String name;

    /**
     * 枚举数据库存储值
     */
    @Override
    public Integer getValue() {
        return null;
    }

    public static PayStatus of(int status) {
        for (PayStatus p : values()) {
            if (p.getStatus() == status) {
                return p;
            }
        }
        return DEFAULT;
    }
}
