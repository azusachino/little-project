package cn.az.project.test.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 考试表
 *
 * @author Liz
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考试ID
     */
    @TableId(value = "TEST_ID", type = IdType.AUTO)
    private Integer testId;

    /**
     * 考试名称
     */
    @TableField("TEST_NAME")
    private String testName;

    /**
     * 年级ID
     */
    @TableField("GRADE_ID")
    private String gradeId;

    /**
     * 试卷ID
     */
    @TableField("PAPER_ID")
    private String paperId;

    /**
     * 课程ID
     */
    @TableField("SUBJECT_ID")
    private String subjectId;

    /**
     * 开始时间
     */
    @TableField("START_TIME")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @TableField("END_TIME")
    private LocalDateTime endTime;

    /**
     * 考试时长
     */
    @TableField("TEST_TIME")
    private String testTime;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 上次修改时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 考试状态 1:尚未开始,2:正在考试,3:已结束
     */
    @TableField("STATUS")
    private String status;

    private transient String subject;
    private transient String grade;
}
