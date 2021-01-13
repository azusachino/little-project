package cn.az.project.shop.db.service.impl;

import cn.az.project.shop.db.entity.User;
import cn.az.project.shop.db.mapper.UserMapper;
import cn.az.project.shop.db.service.IUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Liz
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * Gets one by username.
     *
     * @param username the username
     * @return the one by username
     */
    @Override
    public User getOneByUsername(String username) {
        return getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
    }
}
