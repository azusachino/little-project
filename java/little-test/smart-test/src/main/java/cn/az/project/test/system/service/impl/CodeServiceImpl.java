package cn.az.project.test.system.service.impl;

import cn.az.project.test.system.domain.Code;
import cn.az.project.test.system.mapper.CodeMapper;
import cn.az.project.test.system.service.ICodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liz
 */
@Service
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements ICodeService {

    /**
     * Gets types.
     *
     * @return the types
     */
    @Override
    public List<Code> getTypes() {
        return baseMapper.getTypes();
    }

    /**
     * Gets subjects.
     *
     * @return the subjects
     */
    @Override
    public List<Code> getSubjects() {
        return baseMapper.getSubjects();
    }

    /**
     * Gets grades.
     *
     * @return the grades
     */
    @Override
    public List<Code> getGrades() {
        return baseMapper.getGrades();
    }
}
