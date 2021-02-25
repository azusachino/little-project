package cn.az.project.test.system.controller;

import cn.az.project.test.common.domain.RestResponse;
import cn.az.project.test.common.exception.CommonException;
import cn.az.project.test.system.entity.Question;
import cn.az.project.test.system.param.QuestionParam;
import cn.az.project.test.system.service.IQuestionService;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liz
 */
@Slf4j
@RestController
@RequestMapping("/question")
public class QuestionController {

    private String message;

    @Resource
    private IQuestionService questionService;

    @GetMapping
    @RequiresPermissions("quest:view")
    public RestResponse list(@Valid QuestionParam param) {
        return new RestResponse().ok().data(questionService.selectPage(param));
    }

    @PostMapping
    @RequiresPermissions("quest:add")
    public void add(@Valid Question question) throws CommonException {
        try {
            questionService.save(question);
        } catch (Exception e) {
            message = "新增试题失败";
            log.error(message, e);
            throw new CommonException(message);
        }
    }

    @PutMapping
    @RequiresPermissions("quest:update")
    public void update(@Valid Question question) throws CommonException {
        try {
            questionService.updateById(question);
        } catch (Exception e) {
            message = "更新试题失败";
            log.error(message, e);
            throw new CommonException(message);
        }
    }

    @DeleteMapping("/{questionId}")
    @RequiresPermissions("quest:delete")
    public void delete(@PathVariable String questionId) throws CommonException {
        try {
            questionService.removeById(questionId);
        } catch (Exception e) {
            message = "删除试题失败";
            log.error(message, e);
            throw new CommonException(message);
        }
    }

    @DeleteMapping("/{questionIds}")
    @RequiresPermissions("quest:delete")
    public void deleteWithBatch(@PathVariable String questionIds) throws CommonException {
        try {
            String[] ids = questionIds.split(StringPool.COMMA);
            List<String> list = Arrays.asList(ids);
            questionService.removeByIds(list);
        } catch (Exception e) {
            message = "删除试题失败";
            log.error(message, e);
            throw new CommonException(message);
        }
    }

    @GetMapping("/{questionId}")
    public RestResponse detail(@PathVariable String questionId) {
        return null;
    }
}
