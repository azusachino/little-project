package cn.az.replica.mall.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * IndexConfigType
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see IEnum
 * @since 2020 -03-24
 */
@Getter
@AllArgsConstructor
public enum IndexConfigType implements IEnum<Integer> {
    /**
     * Default index config type.
     */
    DEFAULT(0, "DEFAULT"),
    /**
     * Index search hots index config type.
     */
    INDEX_SEARCH_HOT(1, "INDEX_SEARCH_HOT"),
    /**
     * Index search down hots index config type.
     */
    INDEX_SEARCH_DOWN_HOT(2, "INDEX_SEARCH_DOWN_HOT"),
    /**
     * Index goods hot index config type.
     */
    INDEX_GOODS_HOT(3, "INDEX_GOODS_HOT"),
    /**
     * Index goods new index config type.
     */
    INDEX_GOODS_NEW(4, "INDEX_GOODS_NEW"),
    /**
     * Index goods recommond index config type.
     */
    INDEX_GOODS_RECOMMEND(5, "INDEX_GOODS_RECOMMOND");;


    private Integer type;
    private String name;

    /**
     * 枚举数据库存储值
     */
    @Override
    public Integer getValue() {
        return type;
    }

    public static IndexConfigType of(int type) {
        for (IndexConfigType t : values()) {
            if (t.getType() == type) {
                return t;
            }
        }
        return DEFAULT;
    }
}
