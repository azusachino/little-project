package cn.az.project.muxin.controller;

import cn.az.project.muxin.domain.Response;
import cn.az.project.muxin.entity.User;
import cn.az.project.muxin.service.IUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author az
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("registerOrLogin")
    public Response<?> registerOrLogin(@RequestBody User user) {

        userService.getOne(Wrappers.<User>query().eq("username", user.getUsername()));
        return Response.ok();
    }
}
