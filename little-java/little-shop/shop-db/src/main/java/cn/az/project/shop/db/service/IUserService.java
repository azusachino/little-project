package cn.az.project.shop.db.service;

import cn.az.project.shop.db.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * The interface User service.
 *
 * @author Liz
 */
public interface IUserService extends IService<User> {

    /**
     * Gets one by username.
     *
     * @param username the username
     * @return the one by username
     */
    User getOneByUsername(String username);
}
