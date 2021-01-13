package cn.az.project.news.admin.manager;

import cn.az.project.news.core.utils.CommonUtil;
import cn.az.project.news.db.entity.Permission;
import cn.az.project.news.db.entity.Role;
import cn.az.project.news.db.entity.User;
import cn.az.project.news.db.service.ICacheService;
import cn.az.project.news.db.service.IPermissionService;
import cn.az.project.news.db.service.IRoleService;
import cn.az.project.news.db.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Liz
 * @date 2019/10/12
 */
@Service
public class UserManager {

    @Resource
    private ICacheService cacheService;
    @Resource
    private IUserService userService;
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
    public User getUser(String username) {
        return CommonUtil.selectCacheByTemplate(
                () -> this.cacheService.getUser(username),
                () -> this.userService.getOneByUsername(username));
    }

    /**
     * 通过用户名获取用户角色集合
     *
     * @param username 用户名
     * @return 角色集合
     */
    public Set<String> getUserRoles(String username) {
        List<Role> roleList = CommonUtil.selectCacheByTemplate(
                () -> this.cacheService.getRoles(username),
                () -> this.roleService.getUserRoles(username));
        return roleList.stream().map(Role::getRole).collect(Collectors.toSet());
    }

    /**
     * 通过用户名获取用户权限集合
     *
     * @param username 用户名
     * @return 权限集合
     */
    public Set<String> getUserPermissions(String username) {
        List<Permission> permissionList = CommonUtil.selectCacheByTemplate(
                () -> this.cacheService.getPermissions(username),
                () -> this.permissionService.getUserPermissions(username));
        return permissionList.stream().map(Permission::getPermission).collect(Collectors.toSet());
    }

    /**
     * 将用户相关信息添加到 Redis缓存中
     *
     * @param user user
     */
    public void saveUserRedisCache(User user) throws Exception {
        // 缓存用户
        cacheService.saveUser(user.getUsername());
        // 缓存用户角色
        cacheService.saveRoles(user.getUsername());
        // 缓存用户权限
        cacheService.savePermissions(user.getUsername());
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
            cacheService.saveRoles(user.getUsername());
            // 缓存用户权限
            cacheService.savePermissions(user.getUsername());
        }
    }

    /**
     * 通过用户 id集合批量删除用户 Redis缓存
     *
     * @param userIds userIds
     */
    public void deleteUserRedisCache(String... userIds) {
        for (String userId : userIds) {
            User user = userService.getById(userId);
            if (user != null) {
                cacheService.deleteUser(user.getUsername());
                cacheService.deleteRoles(user.getUsername());
                cacheService.deletePermissions(user.getUsername());
            }
        }
    }
}
