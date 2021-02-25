package cn.az.project.test.system.controller;

import cn.az.project.test.common.domain.RestResponse;
import cn.az.project.test.system.domain.Code;
import cn.az.project.test.system.manager.CodeManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Liz
 */
@RestController
@RequestMapping("/code")
public class CodeController {

    @Resource
    private CodeManager codeManager;

    @GetMapping
    public RestResponse code() {
        RestResponse response = new RestResponse();
        List<Code> types = codeManager.getTypes();
        List<Code> subjects = codeManager.getSubjects();
        List<Code> grades = codeManager.getGrades();
        response.put("types", types);
        response.put("subjects", subjects);
        response.put("grades", grades);
        return response.ok().message("获取code信息成功");
    }
}
