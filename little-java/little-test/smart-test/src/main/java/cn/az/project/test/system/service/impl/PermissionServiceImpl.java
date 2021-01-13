package cn.az.project.test.system.service.impl;

import cn.az.project.test.system.entity.Permission;
import cn.az.project.test.system.mapper.PermissionMapper;
import cn.az.project.test.system.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liz
 */
@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    /**
     * Gets user permissions.
     *
     * @param loginId the login id
     * @return the user permissions
     */
    @Override
    public List<Permission> getUserPermissions(String loginId) {
        return baseMapper.findUserPermissions(loginId);
    }
}
