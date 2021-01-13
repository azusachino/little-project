package cn.az.project.test.system.service.impl;

import cn.az.project.test.system.entity.Question;
import cn.az.project.test.system.mapper.QuestionMapper;
import cn.az.project.test.system.param.QuestionParam;
import cn.az.project.test.system.service.IQuestionService;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Liz
 */
@Service("questionService")
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    /**
     * Query with page page.
     *
     * @param param the param
     * @return the page
     */
    @Override
    public IPage<Question> selectPage(QuestionParam param) {
        Page<Question> page = new Page<>(param.getPageIndex(), param.getPageSize());
        return baseMapper.selectPage(page, Wrappers.<Question>lambdaQuery()
            .nested(StringUtils.isNotBlank(param.getParameter()),
                i -> i.like(Question::getTitle, param.getParameter()).or().like(Question::getKnowledge, param.getParameter()))
            .eq(StringUtils.isNotBlank(param.getSubjectId()), Question::getSubjectId, param.getSubjectId())
            .eq(StringUtils.isNotBlank(param.getTypeId()), Question::getTypeId, param.getTypeId())
            .eq(StringUtils.isNotBlank(param.getGradeId()), Question::getGradeId, param.getGradeId())
            .eq(StringUtils.isNotBlank(param.getUserId()), Question::getUserId, param.getUserId())
            .orderByDesc(Question::getCreateTime));
    }

    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 30)
    public Integer addQuestions(List<Question> questionList) {
        if (CollectionUtil.isEmpty(questionList)) {
            return 0;
        }
        saveBatch(questionList);
        throwException();
        return null;
    }

    private void throwException() {
        throw new RuntimeException("故意抛异常");
    }
}
