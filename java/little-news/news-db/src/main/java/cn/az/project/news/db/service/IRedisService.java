package cn.az.project.news.db.service;

import org.springframework.data.redis.RedisConnectionFailureException;

import java.util.Map;
import java.util.Set;

/**
 * The interface Redis service.
 *
 * @author Liz
 */
public interface IRedisService {

    /**
     * 获取 redis key 数量
     *
     * @return Map key size
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Map<String, Object> getKeySize() throws RedisConnectionFailureException;

    /**
     * 获取 redis 内存信息
     *
     * @return Map memory info
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Map<String, Object> getMemoryInfo() throws RedisConnectionFailureException;

    /**
     * 获取 key
     *
     * @param pattern 正则
     * @return Set keys
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    Set<String> getKeys(String pattern) throws RedisConnectionFailureException;

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
     * @return Set<String>  set
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

}
