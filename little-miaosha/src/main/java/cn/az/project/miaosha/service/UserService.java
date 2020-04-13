package cn.az.project.miaosha.service;

import cn.az.project.miaosha.domain.User;

/**
 * The interface User service.
 *
 * @author az
 * @date 2020/4/12
 */
public interface UserService {

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    User getById(int id);

    /**
     * Insert int.
     *
     * @param user the user
     * @return the int
     */
    int insert(User user);
}
