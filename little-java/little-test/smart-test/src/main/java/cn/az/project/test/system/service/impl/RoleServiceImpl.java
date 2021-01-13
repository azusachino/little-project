package cn.az.project.test.system.service.impl;

import cn.az.project.test.system.entity.Role;
import cn.az.project.test.system.mapper.RoleMapper;
import cn.az.project.test.system.service.IRoleService;
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
     * @param loginId the login id
     * @return the user roles
     */
    @Override
    public List<Role> getUserRoles(String loginId) {
        return baseMapper.findUserRoles(loginId);
    }
}
