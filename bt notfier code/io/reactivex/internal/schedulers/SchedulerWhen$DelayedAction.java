/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.schedulers.SchedulerWhen$OnCompletedAction
 *  io.reactivex.internal.schedulers.SchedulerWhen$ScheduledAction
 */
package io.reactivex.internal.schedulers;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.SchedulerWhen;
import java.util.concurrent.TimeUnit;

static class SchedulerWhen.DelayedAction
extends SchedulerWhen.ScheduledAction {
    private final Runnable action;
    private final long delayTime;
    private final TimeUnit unit;

    SchedulerWhen.DelayedAction(Runnable runnable, long l, TimeUnit timeUnit) {
        this.action = runnable;
        this.delayTime = l;
        this.unit = timeUnit;
    }

    protected Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver) {
        return worker.schedule((Runnable)new SchedulerWhen.OnCompletedAction(this.action, completableObserver), this.delayTime, this.unit);
    }
}
