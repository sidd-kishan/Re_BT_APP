/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.android.schedulers.HandlerScheduler$HandlerWorker
 *  io.reactivex.android.schedulers.HandlerScheduler$ScheduledRunnable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.HandlerScheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

final class HandlerScheduler
extends Scheduler {
    private final boolean async;
    private final Handler handler;

    HandlerScheduler(Handler handler, boolean bl) {
        this.handler = handler;
        this.async = bl;
    }

    public Scheduler.Worker createWorker() {
        return new HandlerWorker(this.handler, this.async);
    }

    public Disposable scheduleDirect(Runnable runnable, long l, TimeUnit timeUnit) {
        if (runnable == null) throw new NullPointerException("run == null");
        if (timeUnit == null) throw new NullPointerException("unit == null");
        runnable = RxJavaPlugins.onSchedule((Runnable)runnable);
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.handler, runnable);
        runnable = Message.obtain((Handler)this.handler, (Runnable)scheduledRunnable);
        if (this.async) {
            runnable.setAsynchronous(true);
        }
        this.handler.sendMessageDelayed((Message)runnable, timeUnit.toMillis(l));
        return scheduledRunnable;
    }
}
