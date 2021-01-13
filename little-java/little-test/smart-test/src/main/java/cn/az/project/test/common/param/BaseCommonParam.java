package cn.az.project.test.common.param;

import lombok.Data;

import java.io.Serializable;

/**
 * The type Base param.
 *
 * @author Liz
 */
@Data
public abstract class BaseCommonParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分页size
     */
    private Integer pageSize = 10;

    /**
     * 页码
     */
    private Integer pageIndex = 1;

    /**
     * 搜索用参数
     */
    private String parameter = "";

    /**
     * GRADE
     */
    private String gradeId = "";

    /**
     * SUBJECT
     */
    private String subjectId = "";
}
