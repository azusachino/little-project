package cn.az.project.muxin.service.impl;

import cn.az.project.muxin.entity.Friend;
import cn.az.project.muxin.mapper.FriendMapper;
import cn.az.project.muxin.service.IFriendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author az
 */
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements IFriendService {

}
