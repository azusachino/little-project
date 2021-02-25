package cn.az.project.test.system.controller;

import cn.az.project.test.common.domain.RestResponse;
import cn.az.project.test.system.entity.Class;
import cn.az.project.test.system.param.ClassParam;
import cn.az.project.test.system.service.IClassService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Liz
 */
@RestController
@RequestMapping("/class")
public class ClassController {

    @Resource
    private IClassService classService;

    @GetMapping
    @RequiresPermissions("class:view")
    public RestResponse list(ClassParam classParam) {
        return new RestResponse().ok().data(classService.list(
            new LambdaQueryWrapper<Class>()
                .eq(Class::getGradeId, classParam.getGradeId())
                .eq(Class::getEntryYear, classParam.getEntryYear())
                .orderByDesc(Class::getGradeId)));
    }
}
