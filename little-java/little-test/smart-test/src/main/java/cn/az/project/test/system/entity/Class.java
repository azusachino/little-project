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
 * 班级表
 *
 * @author Liz
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 班级ID
     */
    @TableId(value = "CLASS_ID", type = IdType.AUTO)
    private Integer classId;

    /**
     * 年级ID
     */
    @TableField("GRADE_ID")
    private String gradeId;

    /**
     * 班级序号
     */
    @TableField("CLASS_NO")
    private String classNo;

    /**
     * 入学年份
     */
    @TableField("ENTRY_YEAR")
    private String entryYear;

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
     * 状态 1:在校,2:已毕业
     */
    @TableField("STATUS")
    private String status;

    private transient String grade;
}
