package cn.az.project.test.system.param;

import cn.az.project.test.common.param.BaseCommonParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Liz
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClassParam extends BaseCommonParam {

    private static final long serialVersionUID = 3748147848354460398L;

    private String entryYear;
}
