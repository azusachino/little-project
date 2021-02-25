package cn.az.project.test.system.param;

import cn.az.project.test.common.param.BaseCommonParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Liz
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PaperParam extends BaseCommonParam {

    private static final long serialVersionUID = 6654871970660481008L;

    private String teacher;
}
