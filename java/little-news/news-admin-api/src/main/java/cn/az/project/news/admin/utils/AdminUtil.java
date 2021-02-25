package cn.az.project.news.admin.utils;

import cn.az.project.news.core.jwt.JwtUtil;
import cn.az.project.news.core.utils.CommonUtil;
import cn.az.project.news.core.utils.SpringUtil;
import cn.az.project.news.db.entity.User;
import cn.az.project.news.db.service.ICacheService;
import cn.az.project.news.db.service.IUserService;
import org.apache.shiro.SecurityUtils;

/**
 * @author Liz
 * @date 1/21/2020
 */
public class AdminUtil {

    private AdminUtil() {

    }

    /**
     * 获取当前操作用户
     *
     * @return 用户信息
     */
    public static User getCurrentUser() {
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        String username = JwtUtil.getUsername(token);
        IUserService userService = SpringUtil.getBean(IUserService.class);
        ICacheService cacheService = SpringUtil.getBean(ICacheService.class);

        return CommonUtil.selectCacheByTemplate(
                () -> cacheService.getUser(username),
                () -> userService.getOneByUsername(username));
    }
}
