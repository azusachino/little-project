package cn.az.project.mall.service.impl;

import cn.az.project.mall.entity.UmsAdmin;
import cn.az.project.mall.entity.UmsPermission;
import cn.az.project.mall.mapper.UmsAdminMapper;
import cn.az.project.mall.service.IUmsAdminService;
import cn.az.project.mall.utils.JwtTokenUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author AzusaChino
 * @version 2019-12-14
 */
@Slf4j
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements IUmsAdminService {

    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 根据用户名获取后台管理员
     *
     * @param username the username
     * @return the admin by username
     */
    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return getOne(Wrappers.<UmsAdmin>lambdaQuery().eq(UmsAdmin::getUsername, username));
    }

    /**
     * 注册功能
     *
     * @param umsAdminParam the ums admin param
     * @return the ums admin
     */
    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        umsAdminParam.setCreateTime(LocalDateTime.now());
        umsAdminParam.setStatus(1);
        if (save(umsAdminParam)) {
            return getAdminByUsername(umsAdminParam.getUsername());
        } else {
            return null;
        }
    }

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token string
     */
    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     *
     * @param adminId the admin id
     * @return the permission list
     */
    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return baseMapper.getPermissionList(adminId);
    }
}
