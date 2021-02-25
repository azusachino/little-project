package cn.az.project.shop.db.service;

import cn.az.project.shop.db.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * The interface Admin service.
 *
 * @author Liz
 */
public interface IAdminService extends IService<Admin> {

    /**
     * Gets one by username.
     *
     * @param username the username
     * @return the one by username
     */
    Admin getOneByUsername(String username);

}
