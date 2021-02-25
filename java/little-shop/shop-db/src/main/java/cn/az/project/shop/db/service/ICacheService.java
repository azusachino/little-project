package cn.az.project.shop.db.service;

import cn.az.project.shop.db.entity.Admin;
import cn.az.project.shop.db.entity.Permission;
import cn.az.project.shop.db.entity.Role;

import java.util.List;

/**
 * The interface Cache service.
 *
 * @author Liz
 */
public interface ICacheService {

    /**
     * 测试 Redis是否连接成功
     *
     * @throws Exception the exception
     */
    void testConnect() throws Exception;

    /**
     * Gets user.
     *
     * @param username username
     * @return the user
     * @throws Exception the exception
     */
    Admin getAdmin(String username) throws Exception;

    /**
     * 从缓存中获取用户角色
     *
     * @param username username
     * @return 角色集 roles
     * @throws Exception the exception
     */
    List<Role> getRoles(String username) throws Exception;

    /**
     * 从缓存中获取用户权限
     *
     * @param username username
     * @return 权限集 permissions
     * @throws Exception the exception
     */
    List<Permission> getPermissions(String username) throws Exception;

    /**
     * 缓存用户信息
     *
     * @param username 用户名
     * @throws Exception the exception
     */
    void saveAdmin(String username) throws Exception;

    /**
     * 缓存用户角色信息
     *
     * @param username 用户名
     * @throws Exception the exception
     */
    void saveRoles(String username) throws Exception;

    /**
     * 缓存用户权限信息
     *
     * @param username 用户名
     * @throws Exception the exception
     */
    void savePermissions(String username) throws Exception;

    /**
     * 删除用户信息
     *
     * @param username 用户名
     * @throws Exception the exception
     */
    void deleteAdmin(String username) throws Exception;

    /**
     * 删除用户角色信息
     *
     * @param username 用户名
     * @throws Exception the exception
     */
    void deleteRoles(String username) throws Exception;

    /**
     * 删除用户权限信息
     *
     * @param username 用户名
     * @throws Exception the exception
     */
    void deletePermissions(String username) throws Exception;

}
