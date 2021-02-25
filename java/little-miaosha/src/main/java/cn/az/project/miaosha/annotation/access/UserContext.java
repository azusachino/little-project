package cn.az.project.miaosha.annotation.access;

import cn.az.project.miaosha.domain.MiaoshaUser;

/**
 * @author az
 */
public class UserContext {

    private static ThreadLocal<MiaoshaUser> userHolder = new ThreadLocal<>();

    public static void set(MiaoshaUser mu) {
        userHolder.set(mu);
    }

    public static MiaoshaUser get() {
        return userHolder.get();
    }
}
