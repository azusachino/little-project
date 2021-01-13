package cn.az.project.shop.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 收藏表
 *
 * @author Liz
 */
@Data
@TableName("tb_favorite")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Favorite implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户表的用户ID
     */
    private Integer userId;

    /**
     * 见下
     */
    private Integer valueId;

    /**
     * 收藏类型，如果type=0，则是商品ID；如果type=1，则是专题ID
     */
    private Integer type;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean deleted;


}
