package cn.az.project.test.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Liz
 */
@Data
public class Code {

    @TableId
    private String idx;

    private String val;
}
