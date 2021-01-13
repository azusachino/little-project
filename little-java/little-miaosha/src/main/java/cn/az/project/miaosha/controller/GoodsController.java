package cn.az.project.miaosha.controller;

import cn.az.project.miaosha.domain.MiaoshaUser;
import cn.az.project.miaosha.service.MiaoshaUserService;
import cn.az.project.miaosha.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author az
 * @since 2020-04-13
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    private final MiaoshaUserService miaoshaUserService;

    private final RedisService redisService;

    @Autowired
    public GoodsController(MiaoshaUserService miaoshaUserService, RedisService redisService) {
        this.miaoshaUserService = miaoshaUserService;
        this.redisService = redisService;
    }

    @RequestMapping("/list")
    public String list(HttpServletResponse res, Model model, MiaoshaUser user) {
        model.addAttribute("user", user);
        return "goods_list";
    }

}
