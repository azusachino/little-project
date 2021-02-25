package cn.az.project.shop.core.function;

/**
 * The interface Cache selector.
 *
 * @param <T> the type parameter
 * @author Liz
 * @date 2019/09/12
 */
@FunctionalInterface
public interface CacheSelector<T> {

    /**
     * Select t.
     *
     * @return the t
     * @throws Exception the exception
     */
    T select() throws Exception;
}
