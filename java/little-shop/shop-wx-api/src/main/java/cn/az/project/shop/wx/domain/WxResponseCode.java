package cn.az.project.shop.wx.domain;

/**
 * The interface Wx response code.
 *
 * @author Liz
 * @date 1 /18/2020
 */
public interface WxResponseCode {
    /**
     * The constant AUTH_INVALID_ACCOUNT.
     */
    Integer AUTH_INVALID_ACCOUNT = 700;
    /**
     * The constant AUTH_CAPTCHA_UNSUPPORT.
     */
    Integer AUTH_CAPTCHA_UNSUPPORT = 701;
    /**
     * The constant AUTH_CAPTCHA_FREQUENCY.
     */
    Integer AUTH_CAPTCHA_FREQUENCY = 702;
    /**
     * The constant AUTH_CAPTCHA_UNMATCH.
     */
    Integer AUTH_CAPTCHA_UNMATCH = 703;
    /**
     * The constant AUTH_NAME_REGISTERED.
     */
    Integer AUTH_NAME_REGISTERED = 704;
    /**
     * The constant AUTH_MOBILE_REGISTERED.
     */
    Integer AUTH_MOBILE_REGISTERED = 705;
    /**
     * The constant AUTH_MOBILE_UNREGISTERED.
     */
    Integer AUTH_MOBILE_UNREGISTERED = 706;
    /**
     * The constant AUTH_INVALID_MOBILE.
     */
    Integer AUTH_INVALID_MOBILE = 707;
    /**
     * The constant AUTH_OPENID_UNACCESS.
     */
    Integer AUTH_OPENID_UNACCESS = 708;
    /**
     * The constant AUTH_OPENID_BINDED.
     */
    Integer AUTH_OPENID_BINDED = 709;

    /**
     * The constant GOODS_UNSHELVE.
     */
    Integer GOODS_UNSHELVE = 710;
    /**
     * The constant GOODS_NO_STOCK.
     */
    Integer GOODS_NO_STOCK = 711;
    /**
     * The constant GOODS_UNKNOWN.
     */
    Integer GOODS_UNKNOWN = 712;
    /**
     * The constant GOODS_INVALID.
     */
    Integer GOODS_INVALID = 713;

    /**
     * The constant ORDER_UNKNOWN.
     */
    Integer ORDER_UNKNOWN = 720;
    /**
     * The constant ORDER_INVALID.
     */
    Integer ORDER_INVALID = 721;
    /**
     * The constant ORDER_CHECKOUT_FAIL.
     */
    Integer ORDER_CHECKOUT_FAIL = 722;
    /**
     * The constant ORDER_CANCEL_FAIL.
     */
    Integer ORDER_CANCEL_FAIL = 723;
    /**
     * The constant ORDER_PAY_FAIL.
     */
    Integer ORDER_PAY_FAIL = 724;
    /**
     * The constant ORDER_INVALID_OPERATION.
     */
    Integer ORDER_INVALID_OPERATION = 725;
    /**
     * The constant ORDER_COMMENTED.
     */
    Integer ORDER_COMMENTED = 726;
    /**
     * The constant ORDER_COMMENT_EXPIRED.
     */
    Integer ORDER_COMMENT_EXPIRED = 727;

    /**
     * The constant GROUP_EXPIRED.
     */
    Integer GROUP_EXPIRED = 730;
    /**
     * The constant GROUP_OFFLINE.
     */
    Integer GROUP_OFFLINE = 731;
    /**
     * The constant GROUP_FULL.
     */
    Integer GROUP_FULL = 732;
    /**
     * The constant GROUP_JOIN.
     */
    Integer GROUP_JOIN = 733;

    /**
     * The constant COUPON_EXCEED_LIMIT.
     */
    int COUPON_EXCEED_LIMIT = 740;
    /**
     * The constant COUPON_RECEIVE_FAIL.
     */
    int COUPON_RECEIVE_FAIL = 741;
    /**
     * The constant COUPON_CODE_INVALID.
     */
    int COUPON_CODE_INVALID = 742;


}
