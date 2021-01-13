package cn.az.project.shop.admin.controller;

import cn.az.project.shop.admin.utils.AdminUtil;
import cn.az.project.shop.admin.manager.AdminManager;
import cn.az.project.shop.core.domain.RestResponse;
import cn.az.project.shop.core.exception.CommonException;
import cn.az.project.shop.core.jwt.JwtToken;
import cn.az.project.shop.core.jwt.JwtUtil;
import cn.az.project.shop.core.properties.CommonProperties;
import cn.az.project.shop.core.utils.CommonUtil;
import cn.az.project.shop.core.utils.DateUtil;
import cn.az.project.shop.core.utils.IpUtil;
import cn.az.project.shop.core.utils.ShaUtil;
import cn.az.project.shop.db.constant.Setting;
import cn.az.project.shop.db.entity.Admin;
import cn.az.project.shop.db.service.IAdminService;
import cn.az.project.shop.db.service.IRedisService;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @author Liz
 * @date 1/6/2020
 */
@Slf4j
@Validated
@RestController
@RequestMapping("admin/auth")
public class AdminAuthController {

    @Resource
    private IAdminService adminService;

    @Resource
    private IRedisService redisService;

    @Resource
    private AdminManager adminManager;

    @Resource
    private CommonProperties commonProperties;

    @PostMapping("/login")
    public RestResponse login(String username, String password, HttpServletRequest request) throws CommonException {
        RestResponse restResponse = RestResponse.init();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new CommonException("username & password cannot be empty");
        }
        password = ShaUtil.sha256(password);
        Admin admin = adminManager.getAdmin(username);
        if (admin == null) {
            throw new CommonException(username + " did not exist!");
        }
        if (!StringUtils.equals(password, admin.getPassword())) {
            throw new CommonException("username or password wrong");
        }
        String ip = IpUtil.getIpAddr(request);
        admin.setLastLoginIp(ip);
        admin.setLastLoginTime(LocalDateTime.now());
        adminService.updateById(admin);
        log.info("login success, admin: {}", username);

        long timeOut = commonProperties.getTimeOut();
        String token = CommonUtil.encryptToken(JwtUtil.sign(username, password));
        JwtToken jwtToken = new JwtToken(token, DateUtil.formatFullTime(LocalDateTime.now().plusSeconds(timeOut)));

        // ShiroRealm 后台校验用
        redisService.set(Setting.TOKEN_CACHE_PREFIX + token + StringPool.DOT + ip, token, timeOut * 1000);

        restResponse.put("token", token);
        restResponse.put("roles", adminManager.getUserRoles(username));
        restResponse.put("permissions", adminManager.getUserPermissions(username));
        restResponse.put("user", admin.setPassword("***"));
        return restResponse.ok().message("login success, welcome " + username);
    }

    @GetMapping("/profile/{username}")
    public RestResponse profile(@PathVariable String username) {
        Admin admin = adminManager.getAdmin(username);
        if (admin == null) {
            return RestResponse.init().ok().message("something went wrong");
        }
        return RestResponse.init().ok().message("success").data(admin.setPassword("***"));
    }

    @PostMapping("/profile")
    public RestResponse update(@NonNull Admin admin) {
        if (adminService.updateById(admin)) {
            return RestResponse.init().ok().message("success");
        } else {
            return RestResponse.init().ok().message("failed");
        }
    }

    @GetMapping("/logout")
    public RestResponse logout() {
        Admin a = AdminUtil.getCurrentAdmin();

        return RestResponse.init().ok();
    }
}
