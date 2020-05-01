package cn.az.project.miaosha.service.impl;

import cn.az.project.miaosha.function.JedisExecutor;
import cn.az.project.miaosha.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @author az
 * @since 2020-04-13
 */
@Service
public class RedisServiceImpl implements RedisService {

    final JedisPool jedisPool;

    @Autowired
    public RedisServiceImpl(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    private <T> T execute(JedisExecutor<Jedis, T> j) {
        try (Jedis jedis = jedisPool.getResource()) {
            return j.execute(jedis);
        } catch (Exception e) {
            throw new RedisConnectionFailureException(e.getLocalizedMessage());
        }
    }

    /**
     * 获取 key
     *
     * @param pattern 正则
     * @return Set keys
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Set<String> keys(String pattern) throws RedisConnectionFailureException {
        return execute(j -> j.keys(pattern));
    }

    /**
     * get命令
     *
     * @param key key
     * @return String string
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public String get(String key) throws RedisConnectionFailureException {
        return execute(j -> j.get(key));
    }

    /**
     * set命令
     *
     * @param key   key
     * @param value value
     * @return String string
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public String set(String key, String value) throws RedisConnectionFailureException {
        return execute(j -> j.set(key, value));
    }

    /**
     * set 命令
     *
     * @param key     key
     * @param value   value
     * @param miliSeconds 毫秒
     * @return String string
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public String set(String key, String value, Long miliSeconds) throws RedisConnectionFailureException {
        String result = set(key, value);
        pexpire(key, miliSeconds);
        return result;
    }

    /**
     * del命令
     *
     * @param key key
     * @return Long long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Long del(String... key) throws RedisConnectionFailureException {
        return execute(j -> j.del(key));
    }

    /**
     * exists命令
     *
     * @param key key
     * @return Boolean boolean
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Boolean exists(String key) throws RedisConnectionFailureException {
        return execute(j -> j.exists(key));
    }

    /**
     * pttl命令
     *
     * @param key key
     * @return Long long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Long pttl(String key) throws RedisConnectionFailureException {
        return execute(j -> j.pttl(key));
    }

    /**
     * pexpire命令
     *
     * @param key     key
     * @param miliSeconds 毫秒
     * @return Long long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Long pexpire(String key, Long miliSeconds) throws RedisConnectionFailureException {
        return execute(j -> j.pexpire(key, miliSeconds));
    }

    /**
     * zadd 命令
     *
     * @param key    key
     * @param score  score
     * @param member value
     * @return the long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Long zadd(String key, Double score, String member) throws RedisConnectionFailureException {
        return execute(j -> j.zadd(key, score, member));
    }

    /**
     * zrangeByScore 命令
     *
     * @param key key
     * @param min min
     * @param max max
     * @return Set<String> set
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Set<String> zrangeByScore(String key, String min, String max) throws RedisConnectionFailureException {
        return execute(j -> j.zrangeByScore(key, min, max));
    }

    /**
     * zremrangeByScore 命令
     *
     * @param key   key
     * @param start start
     * @param end   end
     * @return Long long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Long zremrangeByScore(String key, String start, String end) throws RedisConnectionFailureException {
        return execute(j -> j.zremrangeByScore(key, start, end));
    }

    /**
     * zrem 命令
     *
     * @param key     key
     * @param members members
     * @return Long long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Long zrem(String key, String... members) throws RedisConnectionFailureException {
        return execute(j -> j.zrem(key, members));
    }

    /**
     * Incr long.
     *
     * @param key the key
     * @return the long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Long incr(String key) throws RedisConnectionFailureException {
        return execute(j -> j.incr(key));
    }

    /**
     * Decr long.
     *
     * @param key the key
     * @return the long
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Long decr(String key) throws RedisConnectionFailureException {
        return execute(j -> j.decr(key));
    }
}
