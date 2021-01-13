package cn.az.project.test.system.service;

import cn.az.project.test.system.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Liz
 */
public interface IRoleService extends IService<Role> {
    /**
     * Gets user roles.
     *
     * @param loginId the login id
     * @return the user roles
     */
    List<Role> getUserRoles(String loginId);
}
