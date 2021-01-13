package cn.az.project.shop.db.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Status enum.
 *
 * @author Liz
 */
@Getter
@AllArgsConstructor
public enum Status implements IEnum<Integer> {
    /**
     * Active status enum.
     */
    ACTIVE(1, "活跃"),
    /**
     * Lock status enum.
     */
    LOCK(2, "冻结"),
    /**
     * Obsolete status enum.
     */
    OBSOLETE(3, "废弃"),
    /**
     * Unsubscribe status enum.
     */
    UNSUBSCRIBE(4, "注销");

    private final Integer id;
    private final String val;

    @Override
    public Integer getValue() {
        return id;
    }
}
