package cn.az.replica.mall.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * OrderStatus
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see IEnum
 * @since 2020 -03-24
 */
@Getter
@AllArgsConstructor
public enum OrderStatus implements IEnum<Integer> {
    /**
     * Default order status.
     */
    DEFAULT(-9, "ERROR"),
    /**
     * Order pre pay order status.
     */
    ORDER_PRE_PAY(0, "待支付"),
    /**
     * Order paid order status.
     */
    ORDER_PAID(1, "已支付"),
    /**
     * Order packaged order status.
     */
    ORDER_PACKAGED(2, "配货完成"),
    /**
     * Order express order status.
     */
    ORDER_EXPRESS(3, "出库成功"),
    /**
     * Order success order status.
     */
    ORDER_SUCCESS(4, "交易成功"),
    /**
     * Order closed by malluser order status.
     */
    ORDER_CLOSED_BY_USER(-1, "手动关闭"),
    /**
     * Order closed by expired order status.
     */
    ORDER_CLOSED_BY_EXPIRED(-2, "超时关闭"),
    /**
     * Order closed by judge order status.
     */
    ORDER_CLOSED_BY_MERCHANT(-3, "商家关闭");;

    private Integer status;
    private String msg;

    /**
     * 枚举数据库存储值
     */
    @Override
    public Integer getValue() {
        return status;
    }

    public static OrderStatus of(int orderStatus) {
        for (OrderStatus s : values()) {
            if (s.getStatus() == orderStatus) {
                return s;
            }
        }
        return DEFAULT;
    }
}
