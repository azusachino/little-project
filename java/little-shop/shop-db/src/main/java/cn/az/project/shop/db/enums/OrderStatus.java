package cn.az.project.shop.db.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author az
 * @since 09/16/20
 */
@Getter
@AllArgsConstructor
public enum OrderStatus implements IEnum<Integer> {

    // 订单状态
    STATUS_CREATE(101, "未付款"),
    STATUS_CANCEL(102, "已取消(系统)"),
    STATUS_AUTO_CANCEL(103, "已取消(系统)"),
    STATUS_ADMIN_CANCEL(104, "已取消(管理员)"),
    STATUS_PAY_GROUP(200, "已付款团购"),
    STATUS_PAY(201, "已付款"),
    STATUS_REFUND(202, "订单取消，退款中"),
    STATUS_REFUND_CONFIRM(203, "已退款"),
    STATUS_GROUP_TIMEOUT(204, "团购已超时"),
    STATUS_SHIP(301, "已发货"),
    STATUS_CONFIRM(401, "已收货"),
    STATUS_AUTO_CONFIRM(402, "已收货(系统)"),
    ;
    private final Integer val;
    private final String status;


    /**
     * 枚举数据库存储值
     */
    @Override
    public Integer getValue() {
        return val;
    }
}
