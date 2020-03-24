package cn.az.project.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author az
 * @date 2020/3/18
 */
@Getter
@AllArgsConstructor
public enum FeedbackType {

    /**
     * 针对优惠券的评论
     */
    CARD("card", "针对优惠券的评论"),
    /**
     * 针对卡包 App 的评论
     */
    APP("app", "针对卡包App的评论");

    /**
     * 评论类型编码
     */
    private String code;

    /**
     * 评论类型描述
     */
    private String desc;
}

