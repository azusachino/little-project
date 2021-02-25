package cn.az.project.test.system.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Liz
 */
@Getter
@AllArgsConstructor
public enum Sex implements IEnum<Integer> {
    /**
     * Active status.
     */
    MALE(1, "男"),
    /**
     * Cancel status.
     */
    FEMALE(2, "女"),
    /**
     * Obsolete status.
     */
    SECRET(3, "私密");

    private Integer id;
    private String val;

    @Override
    public Integer getValue() {
        return id;
    }
}
