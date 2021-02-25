package cn.az.project.test.system.service;

import cn.az.project.test.system.entity.Question;
import cn.az.project.test.system.param.QuestionParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Liz
 */
public interface IQuestionService extends IService<Question> {

    /**
     * Query with page page.
     *
     * @param param the param
     * @return the page
     */
    IPage<Question> selectPage(QuestionParam param);

    /**
     * 批量添加问题
     *
     * @param questionList 问题集合
     * @return 新增结果
     */
    Integer addQuestions(List<Question> questionList);
}
