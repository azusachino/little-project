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
 * 优惠券用户使用表
 *
 * @author Liz
 */
@Data
@TableName("tb_coupon_user")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class CouponUser implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 优惠券ID
     */
    private Integer couponId;

    /**
     * 使用状态, 如果是0则未使用；如果是1则已使用；如果是2则已过期；如果是3则已经下架；
     */
    private Integer status;

    /**
     * 使用时间
     */
    private LocalDateTime usedTime;

    /**
     * 有效期开始时间
     */
    private LocalDateTime startTime;

    /**
     * 有效期截至时间
     */
    private LocalDateTime endTime;

    /**
     * 订单ID
     */
    private Integer orderId;

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
