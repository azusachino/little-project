package cn.az.project.mall.controller;

import cn.az.project.mall.api.CommonResult;
import cn.az.project.mall.service.IUmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author AzusaChino
 * @version 2019-12-13
 */
@Api(tags = "UmsMemberController")
@RestController
@RequestMapping("/ums")
public class UmsMemberController {

    @Resource
    protected IUmsMemberService memberService;

    @ApiOperation("获取验证码")
    @GetMapping(value = "/getAuthCode")
    public CommonResult<?> getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @PostMapping(value = "/verifyAuthCode")
    public CommonResult<?> updatePassword(@RequestParam String telephone,
                                          @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone, authCode);
    }
}
