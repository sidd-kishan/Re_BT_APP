/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.schedulers.InstantPeriodicTask
 *  io.reactivex.internal.schedulers.RxThreadFactory
 *  io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask
 *  io.reactivex.internal.schedulers.ScheduledDirectTask
 *  io.reactivex.internal.schedulers.SchedulerPoolFactory
 *  io.reactivex.internal.schedulers.SingleScheduler$ScheduledWorker
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.InstantPeriodicTask;
import io.reactivex.internal.schedulers.RxThreadFactory;
import io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask;
import io.reactivex.internal.schedulers.ScheduledDirectTask;
import io.reactivex.internal.schedulers.SchedulerPoolFactory;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleScheduler
extends Scheduler {
    private static final String KEY_SINGLE_PRIORITY = "rx2.single-priority";
    static final ScheduledExecutorService SHUTDOWN;
    static final RxThreadFactory SINGLE_THREAD_FACTORY;
    private static final String THREAD_NAME_PREFIX = "RxSingleScheduler";
    final AtomicReference<ScheduledExecutorService> executor;
    final ThreadFactory threadFactory;

    static {
        ScheduledExecutorService scheduledExecutorService;
        SHUTDOWN = scheduledExecutorService = Executors.newScheduledThreadPool(0);
        scheduledExecutorService.shutdown();
        SINGLE_THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_SINGLE_PRIORITY, 5))), true);
    }

    public SingleScheduler() {
        this((ThreadFactory)SINGLE_THREAD_FACTORY);
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<ScheduledExecutorService>();
        this.executor = atomicReference;
        this.threadFactory = threadFactory;
        atomicReference.lazySet(SingleScheduler.createExecutor(threadFactory));
    }

    static ScheduledExecutorService createExecutor(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.create((ThreadFactory)threadFactory);
    }

    public Scheduler.Worker createWorker() {
        return new ScheduledWorker(this.executor.get());
    }

    /*
     * Unable to fully structure code
     */
    public Disposable scheduleDirect(Runnable var1_1, long var2_3, TimeUnit var4_4) {
        var5_5 = new ScheduledDirectTask(RxJavaPlugins.onSchedule((Runnable)var1_1 /* !! */ ));
        if (var2_3 > 0L) ** GOTO lbl6
        try {
            block2: {
                var1_1 /* !! */  = this.executor.get().submit(var5_5);
                break block2;
lbl6:
                // 1 sources

                var1_1 /* !! */  = this.executor.get().schedule(var5_5, var2_3, var4_4);
            }
            var5_5.setFuture(var1_1 /* !! */ );
            return var5_5;
        }
        catch (RejectedExecutionException var1_2) {
            RxJavaPlugins.onError((Throwable)var1_2);
            return EmptyDisposable.INSTANCE;
        }
    }

    /*
     * Unable to fully structure code
     */
    public Disposable schedulePeriodicallyDirect(Runnable var1_1, long var2_4, long var4_5, TimeUnit var6_6) {
        block4: {
            var7_7 = RxJavaPlugins.onSchedule((Runnable)var1_1);
            if (var4_5 > 0L) break block4;
            var1_1 = this.executor.get();
            var7_7 = new InstantPeriodicTask(var7_7, (ExecutorService)var1_1);
            if (var2_4 > 0L) ** GOTO lbl9
            try {
                block5: {
                    var1_1 = var1_1.submit(var7_7);
                    break block5;
lbl9:
                    // 1 sources

                    var1_1 = var1_1.schedule(var7_7, var2_4, var6_6);
                }
                var7_7.setFirst(var1_1);
                return var7_7;
            }
            catch (RejectedExecutionException var1_2) {
                RxJavaPlugins.onError((Throwable)var1_2);
                return EmptyDisposable.INSTANCE;
            }
        }
        var1_1 = new ScheduledDirectPeriodicTask(var7_7);
        try {
            var1_1.setFuture(this.executor.get().scheduleAtFixedRate((Runnable)var1_1, var2_4, var4_5, var6_6));
            return var1_1;
        }
        catch (RejectedExecutionException var1_3) {
            RxJavaPlugins.onError((Throwable)var1_3);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void shutdown() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = this.executor.get();
        if (scheduledExecutorService2 == (scheduledExecutorService = SHUTDOWN)) return;
        scheduledExecutorService2 = this.executor.getAndSet(scheduledExecutorService);
        if (scheduledExecutorService2 == SHUTDOWN) return;
        scheduledExecutorService2.shutdownNow();
    }

    public void start() {
        ExecutorService executorService;
        ScheduledExecutorService scheduledExecutorService;
        ExecutorService executorService2 = null;
        do {
            if ((scheduledExecutorService = this.executor.get()) != SHUTDOWN) {
                if (executorService2 == null) return;
                executorService2.shutdown();
                return;
            }
            executorService = executorService2;
            if (executorService2 == null) {
                executorService = SingleScheduler.createExecutor(this.threadFactory);
            }
            executorService2 = executorService;
        } while (!this.executor.compareAndSet(scheduledExecutorService, (ScheduledExecutorService)executorService));
    }
}
