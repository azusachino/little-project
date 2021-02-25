package cn.az.project.test.system.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Status.
 *
 * @author Liz
 */
@Getter
@AllArgsConstructor
public enum Status implements IEnum<Integer> {
    /**
     * Active status.
     */
    ACTIVE(1, "正常"),
    /**
     * Cancel status.
     */
    CANCEL(2, "已注销"),
    /**
     * Obsolete status.
     */
    OBSOLETE(3, "长时间无人使用");

    private Integer id;
    private String val;

    @Override
    public Integer getValue() {
        return id;
    }

    public static boolean isActive(Status status) {
        return status.getId().intValue() == ACTIVE.getId().intValue();
    }
}
