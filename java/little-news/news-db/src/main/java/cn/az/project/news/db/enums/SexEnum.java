package cn.az.project.news.db.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Sex enum.
 *
 * @author azusachino
 * @version 12 /21/2019
 */
@Getter
@AllArgsConstructor
public enum SexEnum implements IEnum<Integer> {
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


    private Integer id;
    private String val;

    /**
     * 枚举数据库存储值
     */
    @Override
    public Integer getValue() {
        return id;
    }
}
