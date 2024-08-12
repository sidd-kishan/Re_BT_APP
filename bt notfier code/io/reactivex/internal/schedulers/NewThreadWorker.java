/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableContainer
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.schedulers.InstantPeriodicTask
 *  io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask
 *  io.reactivex.internal.schedulers.ScheduledDirectTask
 *  io.reactivex.internal.schedulers.ScheduledRunnable
 *  io.reactivex.internal.schedulers.SchedulerPoolFactory
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.InstantPeriodicTask;
import io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask;
import io.reactivex.internal.schedulers.ScheduledDirectTask;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import io.reactivex.internal.schedulers.SchedulerPoolFactory;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class NewThreadWorker
extends Scheduler.Worker
implements Disposable {
    volatile boolean disposed;
    private final ScheduledExecutorService executor;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.executor = SchedulerPoolFactory.create((ThreadFactory)threadFactory);
    }

    public void dispose() {
        if (this.disposed) return;
        this.disposed = true;
        this.executor.shutdownNow();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public Disposable schedule(Runnable runnable) {
        return this.schedule(runnable, 0L, null);
    }

    public Disposable schedule(Runnable runnable, long l, TimeUnit timeUnit) {
        if (!this.disposed) return this.scheduleActual(runnable, l, timeUnit, null);
        return EmptyDisposable.INSTANCE;
    }

    /*
     * Unable to fully structure code
     */
    public ScheduledRunnable scheduleActual(Runnable var1_1, long var2_3, TimeUnit var4_4, DisposableContainer var5_5) {
        var6_6 = new ScheduledRunnable(RxJavaPlugins.onSchedule((Runnable)var1_1 /* !! */ ), var5_5);
        if (var5_5 != null && !var5_5.add((Disposable)var6_6)) {
            return var6_6;
        }
        if (var2_3 > 0L) ** GOTO lbl8
        try {
            block4: {
                var1_1 /* !! */  = this.executor.submit(var6_6);
                break block4;
lbl8:
                // 1 sources

                var1_1 /* !! */  = this.executor.schedule(var6_6, var2_3, var4_4);
            }
            var6_6.setFuture(var1_1 /* !! */ );
        }
        catch (RejectedExecutionException var1_2) {
            if (var5_5 != null) {
                var5_5.remove((Disposable)var6_6);
            }
            RxJavaPlugins.onError((Throwable)var1_2);
        }
        return var6_6;
    }

    /*
     * Unable to fully structure code
     */
    public Disposable scheduleDirect(Runnable var1_1, long var2_3, TimeUnit var4_4) {
        var5_5 = new ScheduledDirectTask(RxJavaPlugins.onSchedule((Runnable)var1_1 /* !! */ ));
        if (var2_3 > 0L) ** GOTO lbl6
        try {
            block2: {
                var1_1 /* !! */  = this.executor.submit(var5_5);
                break block2;
lbl6:
                // 1 sources

                var1_1 /* !! */  = this.executor.schedule(var5_5, var2_3, var4_4);
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
            var1_1 = RxJavaPlugins.onSchedule((Runnable)var1_1);
            if (var4_5 > 0L) break block4;
            var7_7 = new InstantPeriodicTask((Runnable)var1_1, (ExecutorService)this.executor);
            if (var2_4 > 0L) ** GOTO lbl8
            try {
                block5: {
                    var1_1 = this.executor.submit(var7_7);
                    break block5;
lbl8:
                    // 1 sources

                    var1_1 = this.executor.schedule(var7_7, var2_4, var6_6);
                }
                var7_7.setFirst(var1_1);
                return var7_7;
            }
            catch (RejectedExecutionException var1_2) {
                RxJavaPlugins.onError((Throwable)var1_2);
                return EmptyDisposable.INSTANCE;
            }
        }
        var1_1 = new ScheduledDirectPeriodicTask((Runnable)var1_1);
        try {
            var1_1.setFuture(this.executor.scheduleAtFixedRate((Runnable)var1_1, var2_4, var4_5, var6_6));
            return var1_1;
        }
        catch (RejectedExecutionException var1_3) {
            RxJavaPlugins.onError((Throwable)var1_3);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void shutdown() {
        if (this.disposed) return;
        this.disposed = true;
        this.executor.shutdown();
    }
}
