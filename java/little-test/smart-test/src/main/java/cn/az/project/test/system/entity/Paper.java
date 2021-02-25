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
 * 试卷表
 *
 * @author Liz
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 试卷ID
     */
    @TableId(value = "PAPER_ID", type = IdType.AUTO)
    private Integer paperId;

    /**
     * 年级ID
     */
    @TableField("GRADE_ID")
    private String gradeId;

    /**
     * 课程ID
     */
    @TableField("SUBJECT_ID")
    private String subjectId;

    /**
     * 出卷人ID
     */
    @TableField("USER_ID")
    private String userId;

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
     * 试卷状态 1:正常,2:不可使用
     */
    @TableField("STATUS")
    private String status;

    private transient String subject;
    private transient String grade;
    private transient String username;

}
