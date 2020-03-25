package cn.az.project.netty.server;

import cn.az.project.netty.initializer.HelloServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author az
 * @since 2020-03-25
 */
@Slf4j
public class HelloServer {

    public static void main(String[] args) {

        // Master EventGroup
        EventLoopGroup masterGroup = new NioEventLoopGroup();

        // Slave EventGroup
        EventLoopGroup slaveGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootStrap = new ServerBootstrap();
            bootStrap.group(masterGroup, slaveGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HelloServerInitializer());

            ChannelFuture cf = bootStrap.bind(8088).sync();

            cf.channel().closeFuture().sync();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            masterGroup.shutdownGracefully();
            slaveGroup.shutdownGracefully();
        }
    }
}
