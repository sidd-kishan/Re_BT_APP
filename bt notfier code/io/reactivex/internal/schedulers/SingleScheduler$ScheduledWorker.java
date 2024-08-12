/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableContainer
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.schedulers.ScheduledRunnable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

static final class SingleScheduler.ScheduledWorker
extends Scheduler.Worker {
    volatile boolean disposed;
    final ScheduledExecutorService executor;
    final CompositeDisposable tasks;

    SingleScheduler.ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
        this.executor = scheduledExecutorService;
        this.tasks = new CompositeDisposable();
    }

    public void dispose() {
        if (this.disposed) return;
        this.disposed = true;
        this.tasks.dispose();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    /*
     * Unable to fully structure code
     */
    public Disposable schedule(Runnable var1_1, long var2_3, TimeUnit var4_4) {
        if (this.disposed) {
            return EmptyDisposable.INSTANCE;
        }
        var5_5 = new ScheduledRunnable(RxJavaPlugins.onSchedule((Runnable)var1_1 /* !! */ ), (DisposableContainer)this.tasks);
        this.tasks.add((Disposable)var5_5);
        if (var2_3 > 0L) ** GOTO lbl10
        try {
            block3: {
                var1_1 /* !! */  = this.executor.submit(var5_5);
                break block3;
lbl10:
                // 1 sources

                var1_1 /* !! */  = this.executor.schedule(var5_5, var2_3, var4_4);
            }
            var5_5.setFuture(var1_1 /* !! */ );
            return var5_5;
        }
        catch (RejectedExecutionException var1_2) {
            this.dispose();
            RxJavaPlugins.onError((Throwable)var1_2);
            return EmptyDisposable.INSTANCE;
        }
    }
}
