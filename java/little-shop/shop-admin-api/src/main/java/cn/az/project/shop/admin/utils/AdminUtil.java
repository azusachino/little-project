package cn.az.project.shop.admin.utils;

import cn.az.project.shop.core.jwt.JwtUtil;
import cn.az.project.shop.core.utils.CommonUtil;
import cn.az.project.shop.core.utils.SpringUtil;
import cn.az.project.shop.db.entity.Admin;
import cn.az.project.shop.db.service.IAdminService;
import cn.az.project.shop.db.service.ICacheService;
import org.apache.shiro.SecurityUtils;

/**
 * @author Liz
 * @date 1/6/2020
 */
public class AdminUtil {

    private AdminUtil() {

    }

    /**
     * 获取当前操作用户
     *
     * @return 用户信息
     */
    public static Admin getCurrentAdmin() {
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        String username = JwtUtil.getUsername(token);
        IAdminService adminService = SpringUtil.getBean(IAdminService.class);
        ICacheService cacheService = SpringUtil.getBean(ICacheService.class);

        return CommonUtil.selectCacheByTemplate(
                () -> cacheService.getAdmin(username),
                () -> adminService.getOneByUsername(username));
    }

}
