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
 * 知识点表
 *
 * @author Liz
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Knowledge implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 知识点ID
     */
    @TableId(value = "KNOWLEDGE_ID", type = IdType.AUTO)
    private Integer knowledgeId;

    /**
     * 课程ID
     */
    @TableField("SUBJECT_ID")
    private String subjectId;

    /**
     * 年级ID
     */
    @TableField("GRADE_ID")
    private String gradeId;

    /**
     * 知识点名称
     */
    @TableField("KNOWLEDGE")
    private String knowledge;

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
     * 状态 1:正常,2:不可使用
     */
    @TableField("STATUS")
    private String status;

    private transient String subject;
    private transient String grade;
}
