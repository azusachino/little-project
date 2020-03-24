package cn.az.card.merchant.security;

/**
 * @author az
 * @date 2020/3/17
 */
public class AccessContext {

    private static final ThreadLocal<String> TOKEN = new ThreadLocal<>();

    public static String getToken() {
        return TOKEN.get();
    }

    public static void setToken(String str) {
        TOKEN.set(str);
    }

    public static void clear() {
        TOKEN.remove();
    }

}
