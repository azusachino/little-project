package cn.az.project.test;

import cn.az.project.test.system.param.QuestionParam;
import cn.az.project.test.system.service.IQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class LittleTestApplicationTests {

    @Resource
    private IQuestionService questionService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void questions() {
        questionService.selectPage(new QuestionParam()).getRecords().forEach(q -> log.info(q.toString()));
    }

}
