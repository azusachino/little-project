package cn.az.project.muxin.handler;

import cn.az.project.muxin.domain.ChatMessage;
import cn.az.project.muxin.domain.Content;
import cn.az.project.muxin.service.IChatService;
import cn.az.project.muxin.service.IUserService;
import cn.az.project.muxin.util.JsonUtils;
import cn.hutool.core.collection.CollUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author az
 * @since 2020-03-27
 */
@Slf4j
@Component
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Resource
    private IUserService userService;

    @Resource
    private IChatService chatService;

    public static ChannelGroup USERS = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * Is called for each message of type {@link I}.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param msg the message to handle
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        // 获取客户端传输过来的消息
        String content = msg.text();
        Channel currentChannel = ctx.channel();
        // 1. 获取客户端发来的消息
        Content dataContent = JsonUtils.jsonToPojo(content, Content.class).orElse(new Content());
        String senderId = dataContent.getChatMessage().getSenderId();
        // 2. 判断消息类型，根据不同的类型来处理不同的业务
        switch (dataContent.getAction()) {
            case CONNECT:
                // 	2.1  当websocket 第一次open的时候，初始化channel，把用的channel和userid关联起来
                UserChannelHandler.put(senderId, currentChannel);
                UserChannelHandler.output();
                break;
            case CHAT:
                //  2.2  聊天类型的消息，把聊天记录保存到数据库，同时标记消息的签收状态[未签收]
                ChatMessage chatMsg = dataContent.getChatMessage();
                String msgText = chatMsg.getMsg();
                String receiverId = chatMsg.getReceiverId();

                // 保存消息到数据库，并且标记为 未签收
                chatService.save(null);
                chatMsg.setMsgId("");

                Content dataContentMsg = new Content();
                dataContentMsg.setChatMessage(chatMsg);

                // 发送消息
                // 从全局用户Channel关系中获取接受方的channel
                Channel receiverChannel = UserChannelHandler.get(receiverId);
                if (Objects.isNull(receiverChannel)) {
                    // TODO channel为空代表用户离线，推送消息（JPush，个推，小米推送）
                } else {
                    // 当receiverChannel不为空的时候，从ChannelGroup去查找对应的channel是否存在
                    Channel findChannel = USERS.find(receiverChannel.id());
                    if (Objects.nonNull(findChannel)) {
                        // 用户在线
                        receiverChannel.writeAndFlush(
                            new TextWebSocketFrame(
                                String.valueOf(JsonUtils.objectToJson(dataContentMsg))));
                    } else {
                        // 用户离线 // 推送消息
                    }
                }
                break;
            case SIGNED:
                //  2.3  签收消息类型，针对具体的消息进行签收，修改数据库中对应消息的签收状态[已签收]
                // 扩展字段在signed类型的消息中，代表需要去签收的消息id，逗号间隔
                String msgIdsStr = dataContent.getExtend();
                String[] msgIds = msgIdsStr.split(",");

                List<String> msgIdList = new ArrayList<>();
                for (String mid : msgIds) {
                    if (StringUtils.isNotBlank(mid)) {
                        msgIdList.add(mid);
                    }
                }

                System.out.println(msgIdList.toString());

                if (CollUtil.isNotEmpty(msgIdList)) {
                    // 批量签收
//                    userService.updateMsgSigned(msgIdList);
                }
                break;
            case KEEP_ALIVE:
                //  2.4  心跳类型的消息
                log.info("收到来自channel为[" + currentChannel + "]的心跳包...");
                break;
            default:
                log.error("error action when receiving msg");
                break;

        }
    }

    /**
     * 当客户端连接服务端之后（打开连接）
     * 获取客户端的channel，并且放到ChannelGroup中去进行管理
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        USERS.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        String channelId = ctx.channel().id().asShortText();
        System.out.println("客户端被移除，channelId为：" + channelId);
        // 当触发handlerRemoved，ChannelGroup会自动移除对应客户端的channel
        USERS.remove(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error(cause.getLocalizedMessage(), cause);
        // 发生异常之后关闭连接（关闭channel），随后从ChannelGroup中移除
        ctx.channel().close();
        USERS.remove(ctx.channel());
    }
}
