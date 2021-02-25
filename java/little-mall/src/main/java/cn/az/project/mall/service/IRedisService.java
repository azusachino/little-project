package cn.az.project.mall.service;

/**
 * The interface Redis service.
 *
 * @author azusachino
 * @version 12 /13/2019
 */
public interface IRedisService {
    /**
     * 存储数据
     *
     * @param key   the key
     * @param value the value
     */
    void set(String key, String value);

    /**
     * 获取数据
     *
     * @param key the key
     * @return the string
     */
    String get(String key);

    /**
     * 设置超期时间
     *
     * @param key    the key
     * @param expire the expire
     * @return the boolean
     */
    Long expire(String key, int expire);

    /**
     * 删除数据
     *
     * @param key the key
     */
    void remove(String key);

    /**
     * 自增操作
     *
     * @param key   the key
     * @param delta 自增步长
     * @return the long
     */
    Long increment(String key, long delta);
}
