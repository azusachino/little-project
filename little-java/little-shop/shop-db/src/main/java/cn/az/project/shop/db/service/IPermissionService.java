package cn.az.project.shop.db.service;

import cn.az.project.shop.db.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * The interface Permission service.
 *
 * @author Liz
 */
public interface IPermissionService extends IService<Permission> {

    /**
     * Gets user permissions.
     *
     * @param username the username
     * @return the user permissions
     */
    List<Permission> getUserPermissions(String username);
}
