package com.imooc.basic.learn_threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {

    private static AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;
    private final boolean daemon;

    /**
     * Constructor accepting the prefix of the threads that will be created by this {@link ThreadFactory}
     *
     * @param namePrefix Prefix for names of threads
     */
    public NamedThreadFactory(String namePrefix, boolean daemon) {
        this.namePrefix = namePrefix;
        this.daemon = daemon;

    }

    /**
     * Constructor accepting the prefix of the threads that will be created by this {@link ThreadFactory}
     *
     * @param namePrefix Prefix for names of threads
     */
    public NamedThreadFactory(String namePrefix) {
        this(namePrefix, false);
    }

    /**
     * Returns a new thread using a name as specified by this factory {@inheritDoc}
     */
    @Override
    public Thread newThread(Runnable runnable) {
        final Thread thread = new Thread(runnable, namePrefix + " thread-" + threadNumber.getAndIncrement());
        thread.setDaemon(daemon);
        return thread;
    }

}