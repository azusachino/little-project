package cn.az.project.shop.admin.manager;

import cn.az.project.shop.core.utils.CommonUtil;
import cn.az.project.shop.db.entity.Admin;
import cn.az.project.shop.db.entity.Permission;
import cn.az.project.shop.db.entity.Role;
import cn.az.project.shop.db.service.IAdminService;
import cn.az.project.shop.db.service.ICacheService;
import cn.az.project.shop.db.service.IPermissionService;
import cn.az.project.shop.db.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Liz
 * @date 1/6/2020
 */
@Service
public class AdminManager {

    @Resource
    private ICacheService cacheService;
    @Resource
    private IAdminService adminService;
    @Resource
    private IRoleService roleService;
    @Resource
    private IPermissionService permissionService;

    /**
     * 通过登录名获取用户基本信息
     *
     * @param username 登录名
     * @return 用户基本信息
     */
    public Admin getAdmin(String username) {
        return CommonUtil.selectCacheByTemplate(
                () -> cacheService.getAdmin(username),
                () -> adminService.getOneByUsername(username));
    }

    /**
     * 通过用户名获取用户角色集合
     *
     * @param username 用户名
     * @return 角色集合
     */
    public Set<String> getUserRoles(String username) {
        List<Role> roleList = CommonUtil.selectCacheByTemplate(
                () -> cacheService.getRoles(username),
                () -> roleService.getUserRoles(username));
        return roleList.stream().map(Role::getName).collect(Collectors.toSet());
    }

    /**
     * 通过用户名获取用户权限集合
     *
     * @param username 用户名
     * @return 权限集合
     */
    public Set<String> getUserPermissions(String username) {
        List<Permission> permissionList = CommonUtil.selectCacheByTemplate(
                () -> cacheService.getPermissions(username),
                () -> permissionService.getUserPermissions(username));
        return permissionList.stream().map(Permission::getPermission).collect(Collectors.toSet());
    }

    /**
     * 将用户相关信息添加到 Redis缓存中
     *
     * @param admin admin
     */
    public void saveUserRedisCache(Admin admin) throws Exception {
        // 缓存用户
        cacheService.saveAdmin(admin.getUsername());
        // 缓存用户角色
        cacheService.saveRoles(admin.getUsername());
        // 缓存用户权限
        cacheService.savePermissions(admin.getUsername());
    }

    /**
     * 将用户角色和权限添加到 Redis缓存中
     *
     * @param userIds userIds
     */
    public void saveUserPermissionRoleRedisCache(List<String> userIds) throws Exception {
        for (String userId : userIds) {
            Admin admin = adminService.getById(userId);
            // 缓存用户角色
            cacheService.saveRoles(admin.getUsername());
            // 缓存用户权限
            cacheService.savePermissions(admin.getUsername());
        }
    }

    /**
     * 通过用户 id集合批量删除用户 Redis缓存
     *
     * @param userIds userIds
     */
    public void deleteUserRedisCache(String... userIds) throws Exception {
        for (String userId : userIds) {
            Admin admin = adminService.getById(userId);
            if (admin != null) {
                cacheService.deleteAdmin(admin.getUsername());
                cacheService.deleteRoles(admin.getUsername());
                cacheService.deletePermissions(admin.getUsername());
            }
        }
    }
}
