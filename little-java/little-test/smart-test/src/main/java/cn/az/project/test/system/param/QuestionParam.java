package cn.az.project.test.system.param;

import cn.az.project.test.common.param.BaseCommonParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * The type Question param.
 *
 * @author Liz
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class QuestionParam extends BaseCommonParam {

    private static final long serialVersionUID = 1233077883152543560L;

    private String typeId;

    private String userId;
}
