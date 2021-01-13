package cn.az.project.test.system.controller;

import cn.az.project.test.common.domain.RestResponse;
import cn.az.project.test.system.entity.Knowledge;
import cn.az.project.test.system.param.KnowledgeParam;
import cn.az.project.test.system.service.IKnowledgeService;
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
@RequestMapping("/knowledge")
public class KnowledgeController {

    @Resource
    private IKnowledgeService knowledgeService;

    @GetMapping
    @RequiresPermissions("knowledge:view")
    public RestResponse index(KnowledgeParam param) {
        return new RestResponse().ok().data(knowledgeService.list(
            new LambdaQueryWrapper<Knowledge>()
                .eq(Knowledge::getGradeId, param.getGradeId())
                .eq(Knowledge::getSubjectId, param.getSubjectId())
                .orderByDesc(Knowledge::getUpdateTime)
        ));
    }
}
