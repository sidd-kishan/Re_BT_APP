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

static class SchedulerWhen.ImmediateAction
extends SchedulerWhen.ScheduledAction {
    private final Runnable action;

    SchedulerWhen.ImmediateAction(Runnable runnable) {
        this.action = runnable;
    }

    protected Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver) {
        return worker.schedule((Runnable)new SchedulerWhen.OnCompletedAction(this.action, completableObserver));
    }
}
