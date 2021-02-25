package cn.az.project.test.system.entity;

import cn.az.project.test.system.enums.Sex;
import cn.az.project.test.system.enums.Status;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表
 *
 * @author Liz
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Integer userId;

    /**
     * 登录ID
     */
    @TableField("LOGIN_ID")
    private String loginId;

    /**
     * 姓名
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 登陆密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 性别 0:保密,1:男,2:女
     */
    @TableField("SEX")
    private Sex sex;

    /**
     * 头像地址
     */
    @TableField("AVATAR")
    private String avatar;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 上次修改时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 上次登录时间
     */
    @TableField("LAST_LOGIN_TIME")
    private LocalDateTime lastLoginTime;

    /**
     * 账户状态 1:正常,2:已注销,3:长时间无人使用
     */
    @TableField("STATUS")
    private Status status;
}
