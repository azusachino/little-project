package cn.az.replica.mall.service.impl;

import cn.az.replica.mall.entity.AdminUser;
import cn.az.replica.mall.mapper.AdminUserMapper;
import cn.az.replica.mall.service.IAdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author az
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements IAdminUserService {

}
