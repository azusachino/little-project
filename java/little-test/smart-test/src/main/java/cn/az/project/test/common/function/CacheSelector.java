package cn.az.project.test.common.function;

/**
 * The interface Cache selector.
 *
 * @param <T> the type parameter
 * @author Liz
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
