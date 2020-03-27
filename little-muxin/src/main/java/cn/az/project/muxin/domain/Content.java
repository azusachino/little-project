package cn.az.project.muxin.domain;

import cn.az.project.muxin.enums.MessageActionEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author az
 * @since 2020-03-27
 */
@Data
public class Content implements Serializable {

    private static final long serialVersionUID = 6565318523835302479L;

    /**
     * 动作类型
     */
    private MessageActionEnum action;

    /**
     * 用户的聊天内容
     */
    private ChatMessage chatMessage;

    /**
     * 扩展字段
     */
    private String extend;
}
