package cn.az.project.news.core.function;

/**
 * The interface Cache selector.
 *
 * @param <T> the type parameter
 * @author azusachino
 * @version 12 /20/2019
 */
@FunctionalInterface
public interface CacheSelector<T> {

    /**
     * Get t.
     *
     * @return the t
     * @throws Exception the exception
     */
    T get() throws Exception;
}
