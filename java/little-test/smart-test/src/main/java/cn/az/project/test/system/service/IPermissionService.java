package cn.az.project.test.system.service;

import cn.az.project.test.system.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Liz
 */
public interface IPermissionService extends IService<Permission> {

    /**
     * Gets user permissions.
     *
     * @param loginId the login id
     * @return the user permissions
     */
    List<Permission> getUserPermissions(String loginId);
}
