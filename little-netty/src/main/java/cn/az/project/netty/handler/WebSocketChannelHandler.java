package cn.az.project.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * for process msg
 * {@link TextWebSocketFrame} the helper for processing text in netty
 *
 * @author az
 * @date 2020/3/25
 */
@Slf4j
public class WebSocketChannelHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup CLIENTS = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        String content = msg.text();
        log.debug("receiving msg: {}", content);
        // or using for each
        CLIENTS.writeAndFlush(new TextWebSocketFrame("[Time: ]" + LocalDateTime.now() + " [msg: ]" + content));
    }

    /**
     * after client's connection, acquire client's channel, adding to channel group for management
     *
     * @param ctx ChannelHandlerContext
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        CLIENTS.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        log.debug("removing client {} from clients", ctx.channel().id().asLongText());
        CLIENTS.remove(ctx.channel());
    }
}
