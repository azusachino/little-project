package cn.az.project.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>后台用户角色表</p>
 *
 * @author AzusaChino
 * @version 2019-12-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmsRole implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 后台用户数量
     */
    private Integer adminCount;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 启用状态：0->禁用；1->启用
     */
    private Integer status;
    private Integer sort;


}
