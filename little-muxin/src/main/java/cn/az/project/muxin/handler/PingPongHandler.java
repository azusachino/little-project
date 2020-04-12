package cn.az.project.muxin.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author az
 * @since 2020-03-27
 */
@Slf4j
public class PingPongHandler extends ChannelInboundHandlerAdapter {

    /**
     * Calls {@link ChannelHandlerContext#fireUserEventTriggered(Object)} to forward
     * to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * <p>
     * Sub-classes may override this method to change behavior.
     *
     * @param ctx ChannelHandlerContext
     * @param evt Object
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            switch (event.state()) {
                case READER_IDLE:
                    log.info("entering read idle");
                    break;
                case WRITER_IDLE:
                    log.info("entering write idle");
                    break;
                case ALL_IDLE:
                    log.info("channel关闭前，users的数量为： {}", ChatHandler.USERS.size());
                    Channel channel = ctx.channel();
                    channel.close();
                    log.info("channel关闭前，users的数量为： {}", ChatHandler.USERS.size());
                    break;
                default:
                    log.error("no state when user event triggered");
                    break;
            }
        }
    }
}
