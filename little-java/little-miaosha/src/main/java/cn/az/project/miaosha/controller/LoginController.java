package cn.az.project.miaosha.controller;

import cn.az.project.miaosha.domain.vo.LoginVO;
import cn.az.project.miaosha.result.CodeMessage;
import cn.az.project.miaosha.result.Result;
import cn.az.project.miaosha.service.MiaoshaUserService;
import cn.az.project.miaosha.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author az
 * @since 2020-04-13
 */
@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    private final MiaoshaUserService miaoshaUserService;

    private final RedisService redisService;

    @Autowired
    public LoginController(MiaoshaUserService miaoshaUserService, RedisService redisService) {
        this.miaoshaUserService = miaoshaUserService;
        this.redisService = redisService;
    }

    @RequestMapping("")
    public String toLogin() {
        return "login";
    }

    @ResponseBody
    @RequestMapping("/do_login")
    public Result<?> doLogin(HttpServletResponse res, @Valid LoginVO loginVO) {
        log.info(loginVO.toString());

        if (miaoshaUserService.login(res, loginVO)) {
            return Result.success(null);
        } else {
            return Result.error(CodeMessage.SERVER_ERROR);
        }
    }
}
