package cn.az.project.test.system.controller;

import cn.az.project.test.common.constant.Setting;
import cn.az.project.test.common.domain.RestResponse;
import cn.az.project.test.common.exception.CommonException;
import cn.az.project.test.common.jwt.JwtUtil;
import cn.az.project.test.common.properties.CommonProperties;
import cn.az.project.test.common.service.RedisService;
import cn.az.project.test.common.utils.CommonUtil;
import cn.az.project.test.common.utils.DateUtil;
import cn.az.project.test.common.utils.IpUtil;
import cn.az.project.test.common.utils.Md5Util;
import cn.az.project.test.system.entity.User;
import cn.az.project.test.system.enums.Status;
import cn.az.project.test.system.manager.UserManager;
import cn.az.project.test.system.service.IUserService;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author Liz
 */
@RestController
public class LoginController {

    @Resource
    private UserManager userManager;
    @Resource
    private RedisService redisService;
    @Resource
    private CommonProperties commonProperties;
    @Resource
    private IUserService userService;

    @PostMapping("/login")
    public RestResponse login(@NotBlank(message = "{required}") String loginId,
                              @NotBlank(message = "{required}") String password, HttpServletRequest request) throws Exception {
        password = Md5Util.encrypt(loginId, password);
        User user = userManager.getUser(loginId);

        if (user == null) {
            throw new CommonException("user did not exist");
        }
        if (!StringUtils.equals(user.getPassword(), password)) {
            throw new CommonException("wrong password");
        }
        if (!Status.isActive(user.getStatus())) {
            throw new CommonException("you are not active user");
        }

        userService.updateLoginTime(String.valueOf(user.getUserId()));

        String token = CommonUtil.encryptToken(JwtUtil.sign(loginId, password));
        String expireTime = DateUtil.formatFullTime(LocalDateTime.now().plusSeconds(commonProperties.getTimeOut()));
        String ip = IpUtil.getIpAddr(request);
        RestResponse response = new RestResponse();

        redisService.set(Setting.TOKEN_CACHE_PREFIX + token + StringPool.DOT + ip, token, commonProperties.getTimeOut() * 1000);

        response.put("token", token);
        response.put("expireTime", expireTime);

        return response.ok().message("登录成功, 欢迎" + user.getUsername());
    }

    @GetMapping("/info")
    public RestResponse info() throws Exception {
        User currentUser = CommonUtil.getCurrentUser();
        if (currentUser == null) {
            throw new CommonException("获取当前用户信息时发生了问题");
        }
        RestResponse response = new RestResponse();
        response.put("user", currentUser.setPassword("It's a secret!"));
        response.put("roles", userManager.getUserRoles(currentUser.getLoginId()));
        response.put("permissions", userManager.getUserPermissions(currentUser.getLoginId()));
        return response.ok().message("当前用户信息获取成功");
    }

    @GetMapping("/logout")
    public RestResponse logout(HttpServletRequest request) throws Exception {
        String token = request.getHeader("SmartToken");
        if (StringUtils.isBlank(token)) {
            throw new CommonException("获取token时发生了问题");
        } else {
            redisService.del(Setting.TOKEN_CACHE_PREFIX + token + StringPool.DOT + IpUtil.getIpAddr(request));
        }
        return new RestResponse().ok().message("登出成功!");
    }
}
