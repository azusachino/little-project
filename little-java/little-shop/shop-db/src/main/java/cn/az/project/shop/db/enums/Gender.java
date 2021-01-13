package cn.az.project.shop.db.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Sex enum.
 *
 * @author Liz
 * @version 2019/12/22
 */
@Getter
@AllArgsConstructor
public enum Gender implements IEnum<Integer> {
    /**
     * Male sex enum.
     */
    MALE(1, "男"),
    /**
     * Female sex enum.
     */
    FEMALE(2, "女"),
    /**
     * Secret sex enum.
     */
    SECRET(3, "保密");

    private final Integer id;
    private final String val;

    @Override
    public Integer getValue() {
        return id;
    }
}
