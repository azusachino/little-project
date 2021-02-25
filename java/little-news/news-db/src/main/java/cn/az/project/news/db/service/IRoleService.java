package cn.az.project.news.db.service;

import cn.az.project.news.db.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Liz
 */
public interface IRoleService extends IService<Role> {
    /**
     * Gets user roles.
     *
     * @param username username
     * @return the user roles
     */
    List<Role> getUserRoles(String username);
}
