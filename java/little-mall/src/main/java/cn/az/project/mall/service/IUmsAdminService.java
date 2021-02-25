package cn.az.project.mall.service;

import cn.az.project.mall.entity.UmsAdmin;
import cn.az.project.mall.entity.UmsPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * The interface Ums admin service.
 *
 * @author AzusaChino
 * @version 2019 -12-14
 */
public interface IUmsAdminService extends IService<UmsAdmin> {

    /**
     * 根据用户名获取后台管理员
     *
     * @param username the username
     * @return the admin by username
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     *
     * @param umsAdminParam the ums admin param
     * @return the ums admin
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token string
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     *
     * @param adminId the admin id
     * @return the permission list
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
