package cn.az.project.news.admin.controller;

import cn.az.project.news.admin.manager.UserManager;
import cn.az.project.news.admin.utils.AdminUtil;
import cn.az.project.news.core.annotation.Limit;
import cn.az.project.news.core.domain.RestResponse;
import cn.az.project.news.core.exception.CommonException;
import cn.az.project.news.core.jwt.JwtUtil;
import cn.az.project.news.core.properties.CommonProperties;
import cn.az.project.news.core.utils.CommonUtil;
import cn.az.project.news.core.utils.DateUtil;
import cn.az.project.news.core.utils.Md5Util;
import cn.az.project.news.db.constant.Setting;
import cn.az.project.news.db.entity.User;
import cn.az.project.news.db.service.IRedisService;
import cn.az.project.news.db.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Liz
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserManager userManager;

    @Resource
    private IUserService userService;

    @Resource
    private IRedisService redisService;

    @Resource
    private CommonProperties properties;

    @PostMapping("/login")
    @Limit(key = "login", period = 60, count = 3, name = "login", prefix = "limit")
    public RestResponse login(@RequestParam String username, @RequestParam String password) throws Exception {
        RestResponse response = RestResponse.init();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return response.code(HttpStatus.BAD_REQUEST).message("username and password cannot be empty");
        }
        User user = userManager.getUser(username);
        if (user == null) {
            throw new CommonException("you are not my user");
        }
        if (!StringUtils.equals(user.getPassword(), Md5Util.md5Encode(password))) {
            throw new CommonException("password wrong");
        }
        if (!user.getStatus().getValue().equals(User.STATUS_VALID)) {
            throw new CommonException("you got locked");
        }
        userService.updateLoginTime(username);

        String token = CommonUtil.encryptToken(JwtUtil.sign(username, password));
        String expireTime = DateUtil.formatFullTime(LocalDateTime.now().plusSeconds(properties.getTimeOut()));

        redisService.zadd(Setting.USERS_ZSET_PREFIX, Double.valueOf(expireTime), String.valueOf(user.getUserId()));
        redisService.set(Setting.TOKEN_CACHE_PREFIX + user.getUserId(), token, properties.getTimeOut() * 1000);

        response.put("token", token);
        response.put("roles", userManager.getUserRoles(username));
        response.put("permissions", userManager.getUserPermissions(username));
        response.put("user", user.setPassword("******"));
        response.put("expireTime", expireTime);
        return response.ok().message("login success");

    }

    @GetMapping("/logout")
    public void logout() {
        User u = AdminUtil.getCurrentUser();
        String now = DateUtil.formatFullTime(LocalDateTime.now());
        String userId = null;
        Set<String> onlineStringSet = redisService.zrangeByScore(Setting.USERS_ZSET_PREFIX, now, "+inf");
        for (String onlineId : onlineStringSet) {
            if (u.getUserId().equals(onlineId)) {
                userId = onlineId;
            }
        }
        if (StringUtils.isNotEmpty(userId)) {
            // 删除 zset中的记录
            redisService.zrem(Setting.USERS_ZSET_PREFIX, userId);
            // 删除对应的 token缓存
            redisService.del(Setting.TOKEN_CACHE_PREFIX + userId);
        }
    }

    @PostMapping("/register")
    public RestResponse register(@RequestParam String username, @RequestParam String password) {
        User user = new User(username, password);
        if (userService.save(user)) {
            return RestResponse.init().ok().message("register success");
        } else {
            return RestResponse.init().code(HttpStatus.INTERNAL_SERVER_ERROR).message("register failed");
        }
    }
}
