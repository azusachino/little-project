package cn.az.project.shop.core.system;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author az
 * @since 09/14/20
 */
public class SystemConfig {

    // 小程序相关配置
    public final static String WX_INDEX_NEW = "wx_index_new";
    public final static String WX_INDEX_HOT = "wx_index_hot";
    public final static String WX_INDEX_BRAND = "wx_index_brand";
    public final static String WX_INDEX_TOPIC = "wx_index_topic";
    public final static String WX_INDEX_CATALOG_LIST = "wx_catalog_list";
    public final static String WX_INDEX_CATALOG_GOODS = "wx_catalog_goods";
    public final static String WX_SHARE = "wx_share";

    public final static String EXPRESS_FREIGHT_VALUE = "express_freight_value";
    public final static String EXPRESS_FREIGHT_MIN = "express_freight_min";

    public final static String ORDER_UNPAID = "order_unpaid";
    public final static String ORDER_NOT_CONFIRM = "order_not_confirm";
    public final static String ORDER_COMMENT = "order_comment";

    public final static String MALL_NAME = "mall_name";
    public final static String MALL_ADDRESS = "mall_address";
    public final static String MALL_PHONE = "mall_phone";
    public final static String MALL_QQ = "mall_qq";
    public final static String MALL_LONGITUDE = "mall_longitude";
    public final static String MALL_LATITUDE = "mall_latitude";

    public final static Map<String, String> DEFAULT_CONFIGS = new HashMap<>();

    static {
        // 小程序相关配置默认值
        DEFAULT_CONFIGS.put(SystemConfig.WX_INDEX_NEW, "6");
        DEFAULT_CONFIGS.put(SystemConfig.WX_INDEX_HOT, "6");
        DEFAULT_CONFIGS.put(SystemConfig.WX_INDEX_BRAND, "4");
        DEFAULT_CONFIGS.put(SystemConfig.WX_INDEX_TOPIC, "4");
        DEFAULT_CONFIGS.put(SystemConfig.WX_INDEX_CATALOG_LIST, "4");
        DEFAULT_CONFIGS.put(SystemConfig.WX_INDEX_CATALOG_GOODS, "4");
        DEFAULT_CONFIGS.put(SystemConfig.WX_SHARE, "false");
        // 运费相关配置默认值
        DEFAULT_CONFIGS.put(SystemConfig.EXPRESS_FREIGHT_VALUE, "8");
        DEFAULT_CONFIGS.put(SystemConfig.EXPRESS_FREIGHT_MIN, "88");
        // 订单相关配置默认值
        DEFAULT_CONFIGS.put(SystemConfig.ORDER_UNPAID, "30");
        DEFAULT_CONFIGS.put(SystemConfig.ORDER_NOT_CONFIRM, "7");
        DEFAULT_CONFIGS.put(SystemConfig.ORDER_COMMENT, "7");
        // 商城相关配置默认值
        DEFAULT_CONFIGS.put(SystemConfig.MALL_NAME, "little_shop");
        DEFAULT_CONFIGS.put(SystemConfig.MALL_ADDRESS, "上海");
        DEFAULT_CONFIGS.put(SystemConfig.MALL_LATITUDE, "31.201900");
        DEFAULT_CONFIGS.put(SystemConfig.MALL_LONGITUDE, "121.587839");
        DEFAULT_CONFIGS.put(SystemConfig.MALL_PHONE, "021-5534-6230");
        DEFAULT_CONFIGS.put(SystemConfig.MALL_QQ, "705144434");
    }

    private static String getConfig(String keyName) {
        return DEFAULT_CONFIGS.get(keyName);
    }

    private static Integer getConfigInt(String keyName) {
        return Integer.parseInt(DEFAULT_CONFIGS.get(keyName));
    }

    private static Boolean getConfigBoolean(String keyName) {
        return Boolean.valueOf(DEFAULT_CONFIGS.get(keyName));
    }

    private static BigDecimal getConfigBigDec(String keyName) {
        return new BigDecimal(DEFAULT_CONFIGS.get(keyName));
    }

    public static Integer getNewLimit() {
        return getConfigInt(WX_INDEX_NEW);
    }

    public static Integer getHotLimit() {
        return getConfigInt(WX_INDEX_HOT);
    }

    public static Integer getBrandLimit() {
        return getConfigInt(WX_INDEX_BRAND);
    }

    public static Integer getTopicLimit() {
        return getConfigInt(WX_INDEX_TOPIC);
    }

    public static Integer getCatalogListLimit() {
        return getConfigInt(WX_INDEX_CATALOG_LIST);
    }

    public static Integer getCatalogMoreLimit() {
        return getConfigInt(WX_INDEX_CATALOG_GOODS);
    }

    public static boolean isAutoCreateShareImage() {
        return getConfigBoolean(WX_SHARE);
    }

    public static BigDecimal getFreight() {
        return getConfigBigDec(EXPRESS_FREIGHT_VALUE);
    }

    public static BigDecimal getFreightLimit() {
        return getConfigBigDec(EXPRESS_FREIGHT_MIN);
    }

    public static Integer getOrderUnpaid() {
        return getConfigInt(ORDER_UNPAID);
    }

    public static Integer getOrderNotConfirm() {
        return getConfigInt(ORDER_NOT_CONFIRM);
    }

    public static Integer getOrderComment() {
        return getConfigInt(ORDER_COMMENT);
    }

    public static String getMallName() {
        return getConfig(MALL_NAME);
    }

    public static String getMallAddress() {
        return getConfig(MALL_ADDRESS);
    }

    public static String getMallPhone() {
        return getConfig(MALL_PHONE);
    }

    public static String getMallQQ() {
        return getConfig(MALL_QQ);
    }

    public static String getMallLongitude() {
        return getConfig(MALL_LONGITUDE);
    }

    public static String getMallLatitude() {
        return getConfig(MALL_LATITUDE);
    }

    public static void updateConfigs(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            DEFAULT_CONFIGS.put(entry.getKey(), entry.getValue());
        }
    }
}
