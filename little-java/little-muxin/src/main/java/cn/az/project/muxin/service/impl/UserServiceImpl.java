package cn.az.project.muxin.service.impl;

import cn.az.project.muxin.entity.User;
import cn.az.project.muxin.mapper.UserMapper;
import cn.az.project.muxin.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author az
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
