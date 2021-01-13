package cn.az.project.news.db.service;

import cn.az.project.news.db.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * The interface User service.
 *
 * @author Liz
 */
public interface IUserService extends IService<User> {

    /**
     * get one by username
     *
     * @param username the login id
     * @return user one by username
     */
    User getOneByUsername(String username);

    /**
     * Update login time.
     *
     * @param username username
     * @return the boolean
     */
    boolean updateLoginTime(String username);
}
