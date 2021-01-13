package cn.az.project.muxin.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Request process enum.
 *
 * @author az
 * @since 2020 -03-27
 */
@Getter
@AllArgsConstructor
public enum RequestProcessEnum implements IEnum<Integer> {

    /**
     * Ignore request process enum.
     */
    IGNORE(0, "忽略"),
    /**
     * Pass request process enum.
     */
    PASS(1, "通过");

    /**
     * The Type.
     */
    public Integer type;
    /**
     * The Msg.
     */
    public String msg;

    /**
     * 枚举数据库存储值
     */
    @Override
    public Integer getValue() {
        return type;
    }
}
