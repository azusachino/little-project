package cn.az.project.news.db.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户类型表
 *
 * @author Liz
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户类型ID
     */
    @TableId("ROLE_ID")
    private Integer roleId;

    /**
     * 用户类型
     */
    @TableField("ROLE")
    private String role;


}
