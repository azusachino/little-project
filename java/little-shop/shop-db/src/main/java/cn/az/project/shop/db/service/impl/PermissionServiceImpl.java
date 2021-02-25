package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Permission;
import cn.az.project.shop.db.mapper.PermissionMapper;
import cn.az.project.shop.db.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liz
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    /**
     * Gets user permissions.
     *
     * @param username the username
     * @return the user permissions
     */
    @Override
    public List<Permission> getUserPermissions(String username) {
        return baseMapper.getUserPermissions(username);
    }
}
