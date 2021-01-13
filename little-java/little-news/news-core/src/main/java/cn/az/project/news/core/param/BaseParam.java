package cn.az.project.news.core.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author azusachino
 * @version 12/21/2019
 */
@Data
public abstract class BaseParam implements Serializable {

    private Integer pageSize;

    private Integer pageNo;

    private String keyword;
}
