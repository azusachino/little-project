package cn.az.project.muxin.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Sign flag enum.
 *
 * @author az
 * @since 2020 -03-27
 */
@Getter
@AllArgsConstructor
public enum SignFlagEnum implements IEnum<Integer> {
    /**
     * Un sign sign flag enum.
     */
    UN_SIGNED(0, "未签收"),
    /**
     * Signed sign flag enum.
     */
    SIGNED(1, "已签收");
    /**
     * The Type.
     */
    public Integer type;
    /**
     * The Content.
     */
    public String content;

    /**
     * 枚举数据库存储值
     */
    @Override
    public Integer getValue() {
        return type;
    }
}
