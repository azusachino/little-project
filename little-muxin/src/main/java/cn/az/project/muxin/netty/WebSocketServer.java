package cn.az.project.muxin.netty;

import cn.az.project.muxin.handler.WebSocketChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author az
 * @since 2020-03-26
 */
public class WebSocketServer {

    private ServerBootstrap server;

    private WebSocketServer() {
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(mainGroup, subGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new WebSocketChannelHandler());
    }

    public void start() {
        ChannelFuture future = server.bind(8088);
        System.out.println("netty websocket server is starting...");
    }

    private static class SingletonServer {
        static final WebSocketServer INSTANCE = new WebSocketServer();
    }

    public static WebSocketServer getInstance() {
        return SingletonServer.INSTANCE;
    }

}
