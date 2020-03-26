package cn.az.project.netty.initializer;

import cn.az.project.netty.handler.HelloChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author az
 * @since 2020-03-25
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel sc) {
        // acquire pipeline from sc
        ChannelPipeline cp = sc.pipeline();

        cp.addLast(HttpServerCodec.class.getName(), new HttpServerCodec());

        cp.addLast(HelloChannelHandler.class.getName(), new HelloChannelHandler());

    }
}
