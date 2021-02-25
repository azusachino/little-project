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
public enum AfterSaleStatus implements IEnum<Integer> {

    // 售后状态
    SUBMIT_ABLE(0, "是可申请"),
    USER_SUBMITTED(1, "用户已申请"),
    ADMIN_PASSED(2, "管理员审核通过"),
    REFUND_SUCCESS(3, "管理员退款成功"),
    ADMIN_DECLINED(4, "管理员审核拒绝"),
    USER_CANCELED(5, "用户已取消"),
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
