package cn.az.project.news.db.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Status enum.
 *
 * @author azusachino
 * @version 12 /21/2019
 */
@Getter
@AllArgsConstructor
public enum StatusEnum implements IEnum<Integer> {
    /**
     * Active status enum.
     */
    ACTIVE(1, "正常"),
    /**
     * Locked status enum.
     */
    LOCKED(2, "冻结"),
    /**
     * Obsolete status enum.
     */
    OBSOLETE(3, "废弃"),
    /**
     * Unsubscribe status enum.
     */
    UNSUBSCRIBE(4, "注销");


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
