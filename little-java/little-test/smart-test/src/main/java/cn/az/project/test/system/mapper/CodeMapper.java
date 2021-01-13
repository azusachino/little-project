package cn.az.project.test.system.mapper;

import cn.az.project.test.system.domain.Code;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * The interface Code mapper.
 *
 * @author Liz
 */
public interface CodeMapper extends BaseMapper<Code> {

    /**
     * Gets types.
     *
     * @return the types
     */
    @Select("select TYPE_ID as idx, TYPE as val from type")
    List<Code> getTypes();

    /**
     * Gets subjects.
     *
     * @return the subjects
     */
    @Select("select SUBJECT_ID as idx, SUBJECT as val from subject")
    List<Code> getSubjects();

    /**
     * Gets grades.
     *
     * @return the grades
     */
    @Select("select GRADE_ID as idx, GRADE as val from grade")
    List<Code> getGrades();
}
