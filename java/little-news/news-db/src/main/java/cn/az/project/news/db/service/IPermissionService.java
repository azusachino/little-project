package cn.az.project.news.db.service;


import cn.az.project.news.db.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
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
