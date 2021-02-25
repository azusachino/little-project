package cn.az.project.miaosha.service;

import org.springframework.data.redis.RedisConnectionFailureException;

import java.util.Set;

/**
 * The interface Redis service.
 *
 * @author az
 * @since 2020-04-13
 */
public interface RedisService {

    /**
     * 获取 key
     *
     * @param pattern 正则
     * @return Set keys
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Set<String> keys(String pattern) throws RedisConnectionFailureException;

    /**
     * get命令
     *
     * @param key key
     * @return String string
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    String get(String key) throws RedisConnectionFailureException;

    /**
     * set命令
     *
     * @param key   key
     * @param value value
     * @return String string
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    String set(String key, String value) throws RedisConnectionFailureException;

    /**
     * set 命令
     *
     * @param key         key
     * @param value       value
     * @param miliSeconds the mili seconds
     * @return String string
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    String set(String key, String value, Long miliSeconds) throws RedisConnectionFailureException;

    /**
     * del命令
     *
     * @param key key
     * @return Long long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Long del(String... key) throws RedisConnectionFailureException;

    /**
     * exists命令
     *
     * @param key key
     * @return Boolean boolean
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Boolean exists(String key) throws RedisConnectionFailureException;

    /**
     * pttl命令
     *
     * @param key key
     * @return Long long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Long pttl(String key) throws RedisConnectionFailureException;

    /**
     * pexpire命令
     *
     * @param key         key
     * @param miliSeconds the mili seconds
     * @return Long long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Long pexpire(String key, Long miliSeconds) throws RedisConnectionFailureException;


    /**
     * zadd 命令
     *
     * @param key    key
     * @param score  score
     * @param member value
     * @return the long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Long zadd(String key, Double score, String member) throws RedisConnectionFailureException;

    /**
     * zrangeByScore 命令
     *
     * @param key key
     * @param min min
     * @param max max
     * @return Set<String>   set
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Set<String> zrangeByScore(String key, String min, String max) throws RedisConnectionFailureException;

    /**
     * zremrangeByScore 命令
     *
     * @param key   key
     * @param start start
     * @param end   end
     * @return Long long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Long zremrangeByScore(String key, String start, String end) throws RedisConnectionFailureException;

    /**
     * zrem 命令
     *
     * @param key     key
     * @param members members
     * @return Long long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Long zrem(String key, String... members) throws RedisConnectionFailureException;

    /**
     * Incr long.
     *
     * @param key the key
     * @return the long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Long incr(String key) throws RedisConnectionFailureException;

    /**
     * Decr long.
     *
     * @param key the key
     * @return the long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Long decr(String key) throws RedisConnectionFailureException;

}
