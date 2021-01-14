package cn.az.replica.mall.function;

/**
 * The interface Call back.
 *
 * @param <T> the type parameter
 * @author az
 * @since 2020-04-01
 */
@FunctionalInterface
public interface CallBack<T> {

    /**
     * Cb.
     *
     * @param source the source
     * @param target the target
     */
    void set(Object source, T target);
}
