/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.schedulers.SchedulerWhen$CreateWorkerFunction$WorkerCompletable
 *  io.reactivex.internal.schedulers.SchedulerWhen$ScheduledAction
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.internal.schedulers.SchedulerWhen;

static final class SchedulerWhen.CreateWorkerFunction
implements Function<SchedulerWhen.ScheduledAction, Completable> {
    final Scheduler.Worker actualWorker;

    SchedulerWhen.CreateWorkerFunction(Scheduler.Worker worker) {
        this.actualWorker = worker;
    }

    public Completable apply(SchedulerWhen.ScheduledAction scheduledAction) {
        return new WorkerCompletable(this, scheduledAction);
    }
}
