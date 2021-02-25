package cn.az.project.shop.db.service;

import cn.az.project.shop.db.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * The interface Role service.
 *
 * @author Liz
 */
public interface IRoleService extends IService<Role> {

    /**
     * Gets user roles.
     *
     * @param username the username
     * @return the user roles
     */
    List<Role> getUserRoles(String username);
}
