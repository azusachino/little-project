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
 * 试题表
 *
 * @author Liz
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 试题ID
     */
    @TableId(value = "QUESTION_ID", type = IdType.AUTO)
    private Integer questionId;

    /**
     * 试题类型ID
     */
    @TableField("TYPE_ID")
    private String typeId;

    /**
     * 试题课程ID
     */
    @TableField("SUBJECT_ID")
    private String subjectId;

    /**
     * 年级ID
     */
    @TableField("GRADE_ID")
    private String gradeId;

    /**
     * 知识点IDs
     */
    @TableField("KNOWLEDGE_ID")
    private String knowledgeId;

    /**
     * 出题人ID
     */
    @TableField("USER_ID")
    private String userId;

    /**
     * 难易度 0:简单,1:中等,2:困难
     */
    @TableField("DIFFICULTY")
    private String difficulty;

    /**
     * 试题内容
     */
    @TableField("TITLE")
    private String title;

    /**
     * 选项A
     */
    @TableField("OPTION_A")
    private String optionA;

    /**
     * 选项B
     */
    @TableField("OPTION_B")
    private String optionB;

    /**
     * 选项C
     */
    @TableField("OPTION_C")
    private String optionC;

    /**
     * 选项D
     */
    @TableField("OPTION_D")
    private String optionD;

    /**
     * 参考答案
     */
    @TableField("ANSWER")
    private String answer;

    /**
     * 注解
     */
    @TableField("REMARK")
    private String remark;

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
     * 试题状态 1:正常,2:不可使用
     */
    @TableField("STATUS")
    private String status;

    private transient String type;
    private transient String subject;
    private transient String grade;
    private transient String knowledge;
    private transient String username;
}
