package cn.az.project.news.db.service.impl;

import cn.az.project.news.db.service.IRedisService;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

/**
 * The type Redis service.
 *
 * @author Liz
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Resource
    JedisPool jedisPool;

    private static String separator = System.getProperty("line.separator");

    /**
     * 处理 jedis请求
     *
     * @param j 处理逻辑，通过 lambda行为参数化
     * @return 处理结果
     */
    private <T> T execute(Function<Jedis, T> j) {
        try (Jedis jedis = jedisPool.getResource()) {
            return j.apply(jedis);
        } catch (Exception e) {
            throw new RedisConnectionFailureException(e.getMessage());
        }
    }

    /**
     * 获取 redis key 数量
     *
     * @return Map key size
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Map<String, Object> getKeySize() throws RedisConnectionFailureException {
        Long dbSize = this.execute(
            j -> {
                Client client = j.getClient();
                client.dbSize();
                return client.getIntegerReply();
            }
        );
        Map<String, Object> map = new HashMap<>(16);
        map.put("create_time", System.currentTimeMillis());
        map.put("dbSize", dbSize);
        return map;
    }

    /**
     * 获取 redis 内存信息
     *
     * @return Map memory info
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Map<String, Object> getMemoryInfo() throws RedisConnectionFailureException {
        String info = this.execute(
            j -> {
                Client client = j.getClient();
                client.info();
                return client.getBulkReply();
            }
        );
        String[] strs = Objects.requireNonNull(info).split(separator);
        Map<String, Object> map = null;
        for (String s : strs) {
            String[] detail = s.split(":");
            if ("used_memory".equals(detail[0])) {
                map = new HashMap<>(16);
                map.put("used_memory", detail[1].substring(0, detail[1].length() - 1));
                map.put("create_time", System.currentTimeMillis());
                break;
            }
        }
        return map;
    }

    /**
     * 获取 key
     *
     * @param pattern 正则
     * @return Set keys
     * @throws RedisConnectionFailureException the redis connection failure exception
     */
    @Override
    public Set<String> getKeys(String pattern) throws RedisConnectionFailureException {
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
     * @param seconds 毫秒
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
     * @param seconds 毫秒
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
}
