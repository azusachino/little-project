package cn.az.project.news.db.service.impl;

import cn.az.project.news.db.entity.Permission;
import cn.az.project.news.db.mapper.PermissionMapper;
import cn.az.project.news.db.service.IPermissionService;
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
     * @param username username
     * @return the user permissions
     */
    @Override
    public List<Permission> getUserPermissions(String username) {
        return baseMapper.findUserPermissions(username);
    }
}
