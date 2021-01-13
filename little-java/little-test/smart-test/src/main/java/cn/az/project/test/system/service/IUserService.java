package cn.az.project.test.system.service;

import cn.az.project.test.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * The interface User service.
 *
 * @author Liz
 */
public interface IUserService extends IService<User> {

    /**
     * Find by login id user.
     *
     * @param loginId the login id
     * @return the user
     */
    User findByLoginId(String loginId);

    /**
     * Update login time.
     *
     * @param userId the user id
     */
    void updateLoginTime(String userId);
}
