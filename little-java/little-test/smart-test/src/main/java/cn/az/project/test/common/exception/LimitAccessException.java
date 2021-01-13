package cn.az.project.test.common.exception;

/**
 * 限流异常
 *
 * @author Liz
 */
public class LimitAccessException extends Exception {

    private static final long serialVersionUID = -3608667856397125671L;

    /**
     * Instantiates a new Limit access exception.
     *
     * @param message the message
     */
    public LimitAccessException(String message) {
        super(message);
    }
}
