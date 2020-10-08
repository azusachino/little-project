package cn.az.project.batch.concurrent;

import org.springframework.lang.NonNull;

import java.util.Map;
import java.util.concurrent.ThreadFactory;

/**
 * save thread
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see ThreadFactory
 * @since 2020-03-17
 */

public class DelegateThreadFactory implements ThreadFactory {

    private final ThreadFactory threadFactory;

    private final Map<String, Thread> threads;

    public DelegateThreadFactory(ThreadFactory threadFactory, Map<String, Thread> threads) {
        this.threadFactory = threadFactory;
        this.threads = threads;
    }

    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     *
     * @param r a runnable to be executed by new thread instance
     * @return constructed thread, or {@code null} if the request to
     * create a thread is rejected
     */
    @Override
    public Thread newThread(@NonNull Runnable r) {
        Thread t = threadFactory.newThread(r);
        threads.putIfAbsent(r.getClass().getName(), t);
        return t;
    }
}
