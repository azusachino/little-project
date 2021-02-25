package cn.az.project.test.system.manager;

import cn.az.project.test.common.service.CacheService;
import cn.az.project.test.common.utils.CommonUtil;
import cn.az.project.test.system.entity.Permission;
import cn.az.project.test.system.entity.Role;
import cn.az.project.test.system.entity.User;
import cn.az.project.test.system.service.IPermissionService;
import cn.az.project.test.system.service.IRoleService;
import cn.az.project.test.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Liz
 */
@Service("userManager")
public class UserManager {

    @Autowired
    private CacheService cacheService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    /**
     * 通过登录名获取用户基本信息
     *
     * @param loginId 登录名
     * @return 用户基本信息
     */
    public User getUser(String loginId) {
        return CommonUtil.selectCacheByTemplate(
            () -> this.cacheService.getUser(loginId),
            () -> this.userService.findByLoginId(loginId));
    }

    /**
     * 通过用户名获取用户角色集合
     *
     * @param username 用户名
     * @return 角色集合
     */
    public Set<String> getUserRoles(String loginId) {
        List<Role> roleList = CommonUtil.selectCacheByTemplate(
            () -> this.cacheService.getRoles(loginId),
            () -> this.roleService.getUserRoles(loginId));
        return roleList.stream().map(Role::getRole).collect(Collectors.toSet());
    }

    /**
     * 通过用户名获取用户权限集合
     *
     * @param username 用户名
     * @return 权限集合
     */
    public Set<String> getUserPermissions(String loginId) {
        List<Permission> permissionList = CommonUtil.selectCacheByTemplate(
            () -> this.cacheService.getPermissions(loginId),
            () -> this.permissionService.getUserPermissions(loginId));
        return permissionList.stream().map(Permission::getPermission).collect(Collectors.toSet());
    }

    /**
     * 将用户相关信息添加到 Redis缓存中
     *
     * @param user user
     */
    public void saveUserRedisCache(User user) throws Exception {
        // 缓存用户
        cacheService.saveUser(user.getLoginId());
        // 缓存用户角色
        cacheService.saveRoles(user.getLoginId());
        // 缓存用户权限
        cacheService.savePermissions(user.getLoginId());
    }

    /**
     * 将用户角色和权限添加到 Redis缓存中
     *
     * @param userIds userIds
     */
    public void saveUserPermissionRoleRedisCache(List<String> userIds) throws Exception {
        for (String userId : userIds) {
            User user = userService.getById(userId);
            // 缓存用户角色
            cacheService.saveRoles(user.getLoginId());
            // 缓存用户权限
            cacheService.savePermissions(user.getLoginId());
        }
    }

    /**
     * 通过用户 id集合批量删除用户 Redis缓存
     *
     * @param userIds userIds
     */
    public void deleteUserRedisCache(String... userIds) throws Exception {
        for (String userId : userIds) {
            User user = userService.getById(userId);
            if (user != null) {
                cacheService.deleteUser(user.getLoginId());
                cacheService.deleteRoles(user.getLoginId());
                cacheService.deletePermissions(user.getLoginId());
            }
        }
    }
}
