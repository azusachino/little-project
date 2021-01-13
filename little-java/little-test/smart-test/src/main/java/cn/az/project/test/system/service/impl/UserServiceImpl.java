package cn.az.project.test.system.service.impl;

import cn.az.project.test.system.entity.User;
import cn.az.project.test.system.mapper.UserMapper;
import cn.az.project.test.system.service.IUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * The type User service.
 *
 * @author Liz
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * Find by login id user.
     *
     * @param loginId the login id
     * @return the user
     */
    @Override
    public User findByLoginId(String loginId) {
        return getOne(Wrappers.<User>lambdaQuery().eq(User::getLoginId, loginId));
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateLoginTime(String userId) {
        lambdaUpdate().set(User::getLastLoginTime, LocalDateTime.now()).eq(User::getUserId, userId);
    }
}
