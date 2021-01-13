package cn.az.project.test.common.constant;

/**
 * The interface Setting.
 *
 * @author Liz
 */
public interface Setting {

    String STATUS_OK = "1";

    String STATUS_NOT_OK = "2";

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
    String TOKEN_CACHE_PREFIX = "cache.token.";

    /**
     * 存储在线用户的 z set前缀
     */
    String ACTIVE_USERS_ZSET_PREFIX = "user.active";

    String CODE_PREFIX = "cache.code.";

    String SUBJECT = "subject";

    String TYPE = "type";

    String GRADE = "grade";

}
