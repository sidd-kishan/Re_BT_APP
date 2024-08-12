/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.schedulers.SchedulerWhen$CreateWorkerFunction
 *  io.reactivex.internal.schedulers.SchedulerWhen$ScheduledAction
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.SchedulerWhen;

final class SchedulerWhen.CreateWorkerFunction.WorkerCompletable
extends Completable {
    final SchedulerWhen.ScheduledAction action;
    final SchedulerWhen.CreateWorkerFunction this$0;

    SchedulerWhen.CreateWorkerFunction.WorkerCompletable(SchedulerWhen.CreateWorkerFunction createWorkerFunction, SchedulerWhen.ScheduledAction scheduledAction) {
        this.this$0 = createWorkerFunction;
        this.action = scheduledAction;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        completableObserver.onSubscribe((Disposable)this.action);
        this.action.call(this.this$0.actualWorker, completableObserver);
    }
}
