package cn.az.project.shop.db.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum User level.
 *
 * @author Liz
 */
@Getter
@AllArgsConstructor
public enum UserLevel implements IEnum<Integer> {
    /**
     * REGULAR user level.
     */
    REGULAR(1, "Regular"),
    /**
     * Vip user level.
     */
    VIP(2, "Vip"),
    /**
     * Svip user level.
     */
    SVIP(3, "Super Vip");

    private final Integer id;
    private final String val;

    /**
     * 枚举数据库存储值
     */
    @Override
    public Integer getValue() {
        return id;
    }
}
