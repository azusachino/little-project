package cn.az.project.shop.db.constant;

/**
 * The interface Setting.
 *
 * @author Liz
 */
public interface Setting {

    /**
     * The constant USER_CACHE_PREFIX.
     */
    String USER_CACHE_PREFIX = "cache.user.";

    /**
     * The constant USER_ROLE_CACHE_PREFIX.
     */
    String USER_ROLE_CACHE_PREFIX = "cache.user.role.";

    /**
     * The constant USER_PERMISSION_CACHE_PREFIX.
     */
    String USER_PERMISSION_CACHE_PREFIX = "cache.user.permission.";

    /**
     * The constant USER_CONFIG_CACHE_PREFIX.
     */
    String USER_CONFIG_CACHE_PREFIX = "cache.user.config.";

    /**
     * The constant TOKEN_CACHE_PREFIX.
     */
    String TOKEN_CACHE_PREFIX = "cache.user.token.";

    /**
     * The constant ACTIVE_USERS_ZSET_PREFIX.
     */
    String ACTIVE_USERS_ZSET_PREFIX = "cache.user.active.";

}
