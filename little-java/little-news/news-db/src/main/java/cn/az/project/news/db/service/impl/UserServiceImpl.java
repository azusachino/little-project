package cn.az.project.news.db.service.impl;

import cn.az.project.news.db.entity.User;
import cn.az.project.news.db.mapper.UserMapper;
import cn.az.project.news.db.service.IUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * The type User service.
 *
 * @author Liz
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * get one by username
     *
     * @param username the login id
     * @return user one by username
     */
    @Override
    public User getOneByUsername(String username) {
        return baseMapper.selectOne(Wrappers.<User>query().eq("USERNAME", username));
    }

    @Override
    public boolean updateLoginTime(String username) {
        return update(Wrappers.<User>update().set("LAST_LOGIN_TIME", LocalDateTime.now()).eq("USERNAME", username));
    }

}
