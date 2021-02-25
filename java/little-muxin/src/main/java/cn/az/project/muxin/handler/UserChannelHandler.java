package cn.az.project.muxin.handler;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author az
 * @since 2020-03-27
 */
@Slf4j
public class UserChannelHandler {

    private static Map<String, Channel> MANAGER = new ConcurrentHashMap<>(8);

    public static void put(String senderId, Channel channel) {
        MANAGER.put(senderId, channel);
    }

    public static Channel get(String senderId) {
        return MANAGER.get(senderId);
    }

    public static void output() {
        MANAGER.forEach((k, v) -> log.info("User Id: {}, ChannelId: {} \n", k, v));
    }
}
