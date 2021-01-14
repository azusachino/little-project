package cn.az.replica.mall.controller.admin;

import cn.az.replica.mall.base.BaseController;
import cn.az.replica.mall.constant.Constants;
import cn.az.replica.mall.entity.AdminUser;
import cn.az.replica.mall.service.IAdminUserService;
import cn.az.replica.mall.util.Md5Util;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author az
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {

    @Resource
    private IAdminUserService adminUserService;

    @RequestMapping
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "index");
        return "admin/index";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("verifyCode") String verifyCode,
                        HttpSession session) {
        if (StringUtils.isEmpty(verifyCode)) {
            session.setAttribute("errorMsg", "验证码不能为空");
        }
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            session.setAttribute("errorMsg", "用户名或密码不能为空");
            return "admin/login";
        }
        String captchaCode = (String) session.getAttribute(Constants.MALL_VERIFY_CODE_KEY);
        if (StringUtils.isEmpty(captchaCode) || !verifyCode.equals(captchaCode)) {
            session.setAttribute("errorMsg", "验证码错误");
            return "admin/login";
        }
        AdminUser adminUser = adminUserService.getOne(
                Wrappers.<AdminUser>lambdaUpdate()
                        .eq(AdminUser::getLoginUserName, username)
                        .eq(AdminUser::getLoginPassword, Md5Util.hash(password))
        );
        if (Objects.nonNull(adminUser)) {
            session.setAttribute("loginUser", adminUser.getNickName());
            session.setAttribute("loginUserId", adminUser.getAdminUserId());
            //session过期时间设置为7200秒 即两小时
            session.setMaxInactiveInterval(60 * 60 * 2);
            return "redirect:/admin";
        } else {
            session.setAttribute("errorMsg", "登陆失败，请联系作者获得测试账号");
            return "admin/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.removeAttribute("loginUserId");
        session.removeAttribute("loginUser");
        session.removeAttribute("errorMsg");
        return "admin/login";
    }


}
