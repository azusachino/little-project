package cn.az.project.shop.wx.controller;

import cn.az.project.shop.core.domain.RestResponse;
import cn.az.project.shop.core.exception.CommonException;
import cn.az.project.shop.core.utils.CommonUtil;
import cn.az.project.shop.core.utils.IpUtil;
import cn.az.project.shop.core.utils.ShaUtil;
import cn.az.project.shop.db.entity.User;
import cn.az.project.shop.db.service.IUserService;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Liz
 * @date 1/9/2020
 */
@RestController
@RequestMapping("wx/auth")
public class WxAuthController {

    @Resource
    private IUserService userService;

    @RequestMapping("/login")
    public RestResponse login(@NotNull String username, @NotNull String password, HttpServletRequest request) throws CommonException {
        password = ShaUtil.sha256(password);
        User u = userService.getOneByUsername(username);
        if (u == null) {
            throw new CommonException("user not exist!!!");
        }
        if (!StrUtil.equals(password, u.getPassword())) {
            throw new CommonException("username or password wrong");
        }
        switch (u.getStatus()) {
            case LOCK:
                throw new CommonException("account was locked, please contact admin");
            case OBSOLETE:
                throw new CommonException("account obsoleted, please contact admin");
            case UNSUBSCRIBE:
                throw new CommonException("account unsubcribed, please register new one");
            case ACTIVE:
            default:
                break;

        }
        String ip = IpUtil.getIpAddr(CommonUtil.getHttpServletRequest());
        userService.update(u, Wrappers.<User>lambdaUpdate().set(User::getLastLoginTime, LocalDateTime.now()).set(User::getLastLoginIp, ip));

        RestResponse response = RestResponse.init();

        return RestResponse.init().ok();
    }
}
