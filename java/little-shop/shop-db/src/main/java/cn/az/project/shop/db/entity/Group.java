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
 * 团购活动表
 *
 * @author Liz
 */
@Data
@TableName("tb_group")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Group implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关联的订单ID
     */
    private Integer orderId;

    /**
     * 如果是开团用户，则group_id是0；如果是参团用户，则group_id是团购活动ID
     */
    private Integer groupId;

    /**
     * 团购规则ID，关联group_rules表ID字段
     */
    private Integer rulesId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 团购分享图片地址
     */
    private String shareUrl;

    /**
     * 开团用户ID
     */
    private Integer creatorUserId;

    /**
     * 开团时间
     */
    private LocalDateTime creatorUserTime;

    /**
     * 团购活动状态，开团未支付则0，开团中则1，开团失败则2
     */
    private Integer status;

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
