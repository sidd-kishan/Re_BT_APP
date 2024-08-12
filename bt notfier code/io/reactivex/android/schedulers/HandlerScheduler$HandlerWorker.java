/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.android.schedulers.HandlerScheduler$ScheduledRunnable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.HandlerScheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

private static final class HandlerScheduler.HandlerWorker
extends Scheduler.Worker {
    private final boolean async;
    private volatile boolean disposed;
    private final Handler handler;

    HandlerScheduler.HandlerWorker(Handler handler, boolean bl) {
        this.handler = handler;
        this.async = bl;
    }

    public void dispose() {
        this.disposed = true;
        this.handler.removeCallbacksAndMessages((Object)this);
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public Disposable schedule(Runnable runnable, long l, TimeUnit timeUnit) {
        if (runnable == null) throw new NullPointerException("run == null");
        if (timeUnit == null) throw new NullPointerException("unit == null");
        if (this.disposed) {
            return Disposables.disposed();
        }
        runnable = RxJavaPlugins.onSchedule((Runnable)runnable);
        runnable = new HandlerScheduler.ScheduledRunnable(this.handler, runnable);
        Message message = Message.obtain((Handler)this.handler, (Runnable)runnable);
        message.obj = this;
        if (this.async) {
            message.setAsynchronous(true);
        }
        this.handler.sendMessageDelayed(message, timeUnit.toMillis(l));
        if (!this.disposed) return runnable;
        this.handler.removeCallbacks(runnable);
        return Disposables.disposed();
    }
}
