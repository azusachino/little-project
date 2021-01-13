package cn.az.project.mall.service.impl;

import cn.az.project.mall.service.IRedisService;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.function.Function;

/**
 * @author azusachino
 * @version 12/13/2019
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Resource
    protected JedisPool jedisPool;

    private <T> T execute(Function<Jedis, T> j) throws RedisConnectionFailureException {
        try (Jedis jedis = jedisPool.getResource()) {
            return j.apply(jedis);
        } catch (Exception e) {
            throw new RedisConnectionFailureException(e.getMessage());
        }
    }

    /**
     * 存储数据
     *
     * @param key   the key
     * @param value the value
     */
    @Override
    public void set(String key, String value) {
        execute(j -> j.set(key, value));
    }

    /**
     * 获取数据
     *
     * @param key the key
     * @return the string
     */
    @Override
    public String get(String key) {
        return execute(j -> j.get(key));
    }

    /**
     * 设置超期时间
     *
     * @param key    the key
     * @param expire the expire
     * @return the boolean
     */
    @Override
    public Long expire(String key, int expire) {
        return execute(j -> j.expire(key, expire));
    }

    /**
     * 删除数据
     *
     * @param key the key
     */
    @Override
    public void remove(String key) {
        execute(j -> j.del(key));
    }

    /**
     * 自增操作
     *
     * @param key   the key
     * @param delta 自增步长
     * @return the long
     */
    @Override
    public Long increment(String key, long delta) {
        return execute(j -> j.incrBy(key, delta));
    }
}
