package cn.az.replica.mall.controller.mall;

import cn.az.replica.mall.base.BaseController;
import cn.az.replica.mall.constant.Constants;
import cn.az.replica.mall.controller.vo.UserVo;
import cn.az.replica.mall.domain.R;
import cn.az.replica.mall.entity.User;
import cn.az.replica.mall.service.IUserService;
import cn.az.replica.mall.util.Md5Util;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;


/**
 * @author az
 */
@Controller
public class UserController extends BaseController {

    @Resource
    private IUserService userService;

    @GetMapping("/profile")
    public String profile(HttpServletRequest req) {
        req.setAttribute("path", "profile");
        return "mall/profile";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(Constants.MALL_USER_SESSION_KEY);
        return "mall/login";
    }

    @GetMapping("/login")
    public String login() {
        return "mall/login";
    }

    @ResponseBody
    @PostMapping("/login")
    public R<?> login(UserVo userVo,
                      @RequestParam("verifyCode") String verifyCode,
                      HttpSession session) {
        String captchaCode = session.getAttribute(Constants.MALL_VERIFY_CODE_KEY).toString();
        if (!StringUtils.equalsIgnoreCase(verifyCode, captchaCode)) {
            return R.fail("验证码错误", null);
        }
        User user = userService.getOne(Wrappers.<User>query()
                .eq("login_name", userVo.getLoginName())
                .eq("password_md5", Md5Util.hash(userVo.getPassword())));
        if (Objects.isNull(user)) {
            return R.fail("账户名称或者密码错误", null);
        }
        if (user.getLockedFlag() == 1) {
            return R.fail("该账户已被禁用", null);
        }
        BeanUtils.copyProperties(user, userVo);
        session.setAttribute(Constants.MALL_USER_SESSION_KEY, userVo);
        return R.success();
    }

    @GetMapping("/register")
    public String register() {
        return "mall/register";
    }

    @ResponseBody
    @PostMapping("/register")
    public R<?> register(@RequestParam("loginName") String loginName,
                         @RequestParam("verifyCode") String verifyCode,
                         @RequestParam("password") String password,
                         HttpSession session) {
        String captchaCode = session.getAttribute(Constants.MALL_VERIFY_CODE_KEY).toString();
        if (!StringUtils.equalsIgnoreCase(verifyCode, captchaCode)) {
            return R.fail("验证码错误", null);
        }
        List<User> userList = userService.list(Wrappers.<User>query().eq("login_name", loginName));
        if (CollUtil.isNotEmpty(userList) && userList.size() > 0) {
            return R.fail("该账户名已存在", null);
        }
        User user = new User();
        user.setLoginName(loginName);
        user.setPasswordMd5(Md5Util.hash(password));
        if (userService.save(user)) {
            return R.success();
        } else {
            return R.fail();
        }
    }

    @ResponseBody
    @PostMapping("/profile/info")
    public R<?> update(@RequestBody User user) {
        if (userService.updateById(user)) {
            User updatedUser = userService.getById(user.getUserId());
            UserVo vo = new UserVo();
            BeanUtils.copyProperties(updatedUser, vo);
            session.setAttribute(Constants.MALL_USER_SESSION_KEY, vo);
            return R.success();
        } else {
            return R.fail();
        }
    }
}
