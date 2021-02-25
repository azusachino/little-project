package cn.az.replica.mall.service.impl;

import cn.az.replica.mall.entity.User;
import cn.az.replica.mall.mapper.UserMapper;
import cn.az.replica.mall.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author az
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
