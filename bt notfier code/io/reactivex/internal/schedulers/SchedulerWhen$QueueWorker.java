/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.schedulers.SchedulerWhen$DelayedAction
 *  io.reactivex.internal.schedulers.SchedulerWhen$ImmediateAction
 *  io.reactivex.internal.schedulers.SchedulerWhen$ScheduledAction
 *  io.reactivex.processors.FlowableProcessor
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.processors.FlowableProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

static final class SchedulerWhen.QueueWorker
extends Scheduler.Worker {
    private final FlowableProcessor<SchedulerWhen.ScheduledAction> actionProcessor;
    private final Scheduler.Worker actualWorker;
    private final AtomicBoolean unsubscribed;

    SchedulerWhen.QueueWorker(FlowableProcessor<SchedulerWhen.ScheduledAction> flowableProcessor, Scheduler.Worker worker) {
        this.actionProcessor = flowableProcessor;
        this.actualWorker = worker;
        this.unsubscribed = new AtomicBoolean();
    }

    public void dispose() {
        if (!this.unsubscribed.compareAndSet(false, true)) return;
        this.actionProcessor.onComplete();
        this.actualWorker.dispose();
    }

    public boolean isDisposed() {
        return this.unsubscribed.get();
    }

    public Disposable schedule(Runnable runnable) {
        runnable = new SchedulerWhen.ImmediateAction(runnable);
        this.actionProcessor.onNext((Object)runnable);
        return runnable;
    }

    public Disposable schedule(Runnable runnable, long l, TimeUnit timeUnit) {
        runnable = new SchedulerWhen.DelayedAction(runnable, l, timeUnit);
        this.actionProcessor.onNext((Object)runnable);
        return runnable;
    }
}
