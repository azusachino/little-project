package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Role;
import cn.az.project.shop.db.mapper.RoleMapper;
import cn.az.project.shop.db.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liz
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    /**
     * Gets user roles.
     *
     * @param username the username
     * @return the user roles
     */
    @Override
    public List<Role> getUserRoles(String username) {
        return baseMapper.getUserRoles(username);
    }
}
