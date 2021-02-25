package cn.az.project.test.system.service;

import cn.az.project.test.system.domain.Code;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Liz
 */
public interface ICodeService extends IService<Code> {

    /**
     * Gets types.
     *
     * @return the types
     */
    List<Code> getTypes();

    /**
     * Gets subjects.
     *
     * @return the subjects
     */
    List<Code> getSubjects();

    /**
     * Gets grades.
     *
     * @return the grades
     */
    List<Code> getGrades();
}
