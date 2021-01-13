package cn.az.project.muxin.service.impl;

import cn.az.project.muxin.entity.Chat;
import cn.az.project.muxin.mapper.ChatMapper;
import cn.az.project.muxin.service.IChatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author az
 */
@Service
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements IChatService {

}
