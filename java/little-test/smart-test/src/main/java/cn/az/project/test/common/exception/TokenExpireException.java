package cn.az.project.test.common.exception;

/**
 * @author Liz
 **/
public class TokenExpireException extends Exception {

    private static final long serialVersionUID = -8313101744886192005L;

    public TokenExpireException(String message) {
        super(message);
    }
}
