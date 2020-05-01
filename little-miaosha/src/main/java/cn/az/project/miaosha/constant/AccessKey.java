package cn.az.project.miaosha.constant;

/**
 * @author az
 * @date 2020/4/23
 */
public class AccessKey extends BasePrefix {

    private final static String ACCESS = "access";

    private AccessKey(int expire, String prefix) {
        super(expire, prefix);
    }

    public static AccessKey withExpire(int seconds) {
        return new AccessKey(seconds, ACCESS);
    }
}
