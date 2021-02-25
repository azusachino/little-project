package cn.az.replica.mall.constant;

/**
 * Constants
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see cn.az.replica.mall.constant
 * @since 2020-03-24
 */
public interface Constants {


    String FILE_UPLOAD_DIR = "D:\\upload\\";

    int CATEGORY_LEVEL_ONE = 1;
    int CATEGORY_LEVEL_TWO = 2;
    int CATEGORY_LEVEL_THREE = 3;

    /**
     * 首页热卖商品数量
     */
    int INDEX_GOODS_HOT_NUMBER = 4;
    /**
     * 首页新品数量
     */
    int INDEX_GOODS_NEW_NUMBER = 5;
    /**
     * 首页推荐商品数量
     */
    int INDEX_GOODS_RECOMMEND_NUMBER = 10;

    /**
     * session中user的key
     */
    String MALL_USER_SESSION_KEY = "mallUser";
    /**
     * 验证码key
     */
    String MALL_VERIFY_CODE_KEY = "mallVerifyCode";

    /**
     * 搜索分页的默认条数(每页10条)
     */
    int GOODS_SEARCH_PAGE_LIMIT = 10;
    /**
     * 订单列表分页的默认条数(每页3条)
     */
    int ORDER_SEARCH_PAGE_LIMIT = 3;

    /**
     * 字符串表示true
     */
    String TRUE = "true";
    /**
     * 字符串表示false
     */
    String FALSE = "false";

    /**
     * 操作状态，成功
     */
    int OPERATE_SUCCESS = 0;
    /**
     * 操作状态，失败
     */
    int OPERATE_FAIL = 1;

    /**
     * 当前页
     */
    String PAGE_NUMBER = "pageNumber";
    /**
     * 分页大小
     */
    String PAGE_SIZE = "pageSize";
    /**
     * 排序字段名
     */
    String SORT_NAME = "sortName";

    /**
     * 排序方式 asc或者desc
     */
    String SORT_ORDER = "sortOrder";
    String ORDER_DESC = "desc";
    String SORT_ASC = "asc";
}
