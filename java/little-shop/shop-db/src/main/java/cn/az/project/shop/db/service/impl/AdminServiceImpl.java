package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.Admin;
import cn.az.project.shop.db.mapper.AdminMapper;
import cn.az.project.shop.db.service.IAdminService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    /**
     * Gets one by username.
     *
     * @param username the username
     * @return the one by username
     */
    @Override
    public Admin getOneByUsername(String username) {
        return getOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getUsername, username));
    }
}
