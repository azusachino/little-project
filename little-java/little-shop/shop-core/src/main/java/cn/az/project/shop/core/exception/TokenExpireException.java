package cn.az.project.shop.core.exception;

/**
 * @author : Liz
 * @date : 2019/9/19
 **/
public class TokenExpireException extends Exception {

    private static final long serialVersionUID = -8313101744886192005L;

    public TokenExpireException(String message) {
        super(message);
    }
}
