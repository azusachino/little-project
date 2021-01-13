package cn.az.project.shop.core.param;

import lombok.Data;

import java.io.Serializable;

/**
 * The type Base param.
 *
 * @author Liz
 * @date 2019/09/20
 */
@Data
public abstract class BaseParam implements Serializable {

    private static final long serialVersionUID = -4667990364869585637L;

    /**
     * 分页size
     */
    private Integer pageSize = 10;

    /**
     * 页码
     */
    private Integer pageNo = 1;

    /**
     * 搜索用参数
     */
    private String keyword = "";

}
