package cn.az.project.news.db.entity;

import cn.az.project.news.db.enums.SexEnum;
import cn.az.project.news.db.enums.StatusEnum;
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
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账户状态
     */
    public static final Integer STATUS_VALID = 1;
    public static final Integer STATUS_LOCK = 2;
    public static final Integer STATUS_OBSOLETE = 3;
    public static final Integer STATUS_UNSUBSCRIBE = 4;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.sex = SexEnum.SECRET;
        this.status = StatusEnum.ACTIVE;
    }

    /**
     * 用户ID
     */
    @TableId(value = "USER_ID")
    private String userId;

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
    private SexEnum sex;

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
    private StatusEnum status;
}
