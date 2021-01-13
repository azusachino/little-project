package cn.az.project.miaosha.constant;

/**
 * @author az
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
