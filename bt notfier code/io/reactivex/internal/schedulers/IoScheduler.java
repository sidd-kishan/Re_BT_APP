/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.schedulers.IoScheduler$CachedWorkerPool
 *  io.reactivex.internal.schedulers.IoScheduler$EventLoopWorker
 *  io.reactivex.internal.schedulers.IoScheduler$ThreadWorker
 *  io.reactivex.internal.schedulers.RxThreadFactory
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class IoScheduler
extends Scheduler {
    static final RxThreadFactory EVICTOR_THREAD_FACTORY;
    private static final String EVICTOR_THREAD_NAME_PREFIX = "RxCachedWorkerPoolEvictor";
    private static final long KEEP_ALIVE_TIME;
    public static final long KEEP_ALIVE_TIME_DEFAULT = 60L;
    private static final TimeUnit KEEP_ALIVE_UNIT;
    private static final String KEY_IO_PRIORITY = "rx2.io-priority";
    private static final String KEY_KEEP_ALIVE_TIME = "rx2.io-keep-alive-time";
    static final CachedWorkerPool NONE;
    static final ThreadWorker SHUTDOWN_THREAD_WORKER;
    static final RxThreadFactory WORKER_THREAD_FACTORY;
    private static final String WORKER_THREAD_NAME_PREFIX = "RxCachedThreadScheduler";
    final AtomicReference<CachedWorkerPool> pool;
    final ThreadFactory threadFactory;

    static {
        ThreadWorker threadWorker;
        KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
        KEEP_ALIVE_TIME = Long.getLong(KEY_KEEP_ALIVE_TIME, 60L);
        SHUTDOWN_THREAD_WORKER = threadWorker = new ThreadWorker((ThreadFactory)new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        threadWorker.dispose();
        int n = Math.max(1, Math.min(10, Integer.getInteger(KEY_IO_PRIORITY, 5)));
        WORKER_THREAD_FACTORY = new RxThreadFactory(WORKER_THREAD_NAME_PREFIX, n);
        EVICTOR_THREAD_FACTORY = new RxThreadFactory(EVICTOR_THREAD_NAME_PREFIX, n);
        threadWorker = new CachedWorkerPool(0L, null, (ThreadFactory)WORKER_THREAD_FACTORY);
        NONE = threadWorker;
        threadWorker.shutdown();
    }

    public IoScheduler() {
        this((ThreadFactory)WORKER_THREAD_FACTORY);
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        this.pool = new AtomicReference<CachedWorkerPool>(NONE);
        this.start();
    }

    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get());
    }

    public void shutdown() {
        CachedWorkerPool cachedWorkerPool;
        CachedWorkerPool cachedWorkerPool2;
        do {
            if ((cachedWorkerPool2 = this.pool.get()) != (cachedWorkerPool = NONE)) continue;
            return;
        } while (!this.pool.compareAndSet(cachedWorkerPool2, cachedWorkerPool));
        cachedWorkerPool2.shutdown();
    }

    public int size() {
        return this.pool.get().allWorkers.size();
    }

    public void start() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(KEEP_ALIVE_TIME, KEEP_ALIVE_UNIT, this.threadFactory);
        if (this.pool.compareAndSet(NONE, cachedWorkerPool)) return;
        cachedWorkerPool.shutdown();
    }
}
