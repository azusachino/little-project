package cn.az.project.news.db.service.impl;

import cn.az.project.news.db.entity.Role;
import cn.az.project.news.db.mapper.RoleMapper;
import cn.az.project.news.db.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liz
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    /**
     * Gets user roles.
     *
     * @param username the username
     * @return the user roles
     */
    @Override
    public List<Role> getUserRoles(String username) {
        return baseMapper.findUserRoles(username);
    }
}
