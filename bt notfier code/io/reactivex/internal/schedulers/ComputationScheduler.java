/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.schedulers.ComputationScheduler$EventLoopWorker
 *  io.reactivex.internal.schedulers.ComputationScheduler$FixedSchedulerPool
 *  io.reactivex.internal.schedulers.ComputationScheduler$PoolWorker
 *  io.reactivex.internal.schedulers.RxThreadFactory
 *  io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
 *  io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport$WorkerCallback
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.RxThreadFactory;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ComputationScheduler
extends Scheduler
implements SchedulerMultiWorkerSupport {
    private static final String KEY_COMPUTATION_PRIORITY = "rx2.computation-priority";
    static final String KEY_MAX_THREADS = "rx2.computation-threads";
    static final int MAX_THREADS;
    static final FixedSchedulerPool NONE;
    static final PoolWorker SHUTDOWN_WORKER;
    static final RxThreadFactory THREAD_FACTORY;
    private static final String THREAD_NAME_PREFIX = "RxComputationThreadPool";
    final AtomicReference<FixedSchedulerPool> pool;
    final ThreadFactory threadFactory;

    static {
        PoolWorker poolWorker;
        MAX_THREADS = ComputationScheduler.cap(Runtime.getRuntime().availableProcessors(), Integer.getInteger(KEY_MAX_THREADS, 0));
        SHUTDOWN_WORKER = poolWorker = new PoolWorker((ThreadFactory)new RxThreadFactory("RxComputationShutdown"));
        poolWorker.dispose();
        poolWorker = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_COMPUTATION_PRIORITY, 5))), true);
        THREAD_FACTORY = poolWorker;
        poolWorker = new FixedSchedulerPool(0, (ThreadFactory)poolWorker);
        NONE = poolWorker;
        poolWorker.shutdown();
    }

    public ComputationScheduler() {
        this((ThreadFactory)THREAD_FACTORY);
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        this.pool = new AtomicReference<FixedSchedulerPool>(NONE);
        this.start();
    }

    static int cap(int n, int n2) {
        int n3 = n;
        if (n2 <= 0) return n3;
        n3 = n2 > n ? n : n2;
        return n3;
    }

    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get().getEventLoop());
    }

    public void createWorkers(int n, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        ObjectHelper.verifyPositive((int)n, (String)"number > 0 required");
        this.pool.get().createWorkers(n, workerCallback);
    }

    public Disposable scheduleDirect(Runnable runnable, long l, TimeUnit timeUnit) {
        return this.pool.get().getEventLoop().scheduleDirect(runnable, l, timeUnit);
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
        return this.pool.get().getEventLoop().schedulePeriodicallyDirect(runnable, l, l2, timeUnit);
    }

    public void shutdown() {
        FixedSchedulerPool fixedSchedulerPool;
        FixedSchedulerPool fixedSchedulerPool2;
        do {
            if ((fixedSchedulerPool2 = this.pool.get()) != (fixedSchedulerPool = NONE)) continue;
            return;
        } while (!this.pool.compareAndSet(fixedSchedulerPool2, fixedSchedulerPool));
        fixedSchedulerPool2.shutdown();
    }

    public void start() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(MAX_THREADS, this.threadFactory);
        if (this.pool.compareAndSet(NONE, fixedSchedulerPool)) return;
        fixedSchedulerPool.shutdown();
    }
}
