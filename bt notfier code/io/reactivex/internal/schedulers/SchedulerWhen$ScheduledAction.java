/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.schedulers.SchedulerWhen
 */
package io.reactivex.internal.schedulers;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.SchedulerWhen;
import java.util.concurrent.atomic.AtomicReference;

static abstract class SchedulerWhen.ScheduledAction
extends AtomicReference<Disposable>
implements Disposable {
    SchedulerWhen.ScheduledAction() {
        super(SchedulerWhen.SUBSCRIBED);
    }

    void call(Scheduler.Worker worker, CompletableObserver completableObserver) {
        Disposable disposable = (Disposable)this.get();
        if (disposable == SchedulerWhen.DISPOSED) {
            return;
        }
        if (disposable != SchedulerWhen.SUBSCRIBED) {
            return;
        }
        if (this.compareAndSet(SchedulerWhen.SUBSCRIBED, worker = this.callActual(worker, completableObserver))) return;
        worker.dispose();
    }

    protected abstract Disposable callActual(Scheduler.Worker var1, CompletableObserver var2);

    public void dispose() {
        Disposable disposable;
        Disposable disposable2 = SchedulerWhen.DISPOSED;
        do {
            if ((disposable = (Disposable)this.get()) != SchedulerWhen.DISPOSED) continue;
            return;
        } while (!this.compareAndSet(disposable, disposable2));
        if (disposable == SchedulerWhen.SUBSCRIBED) return;
        disposable.dispose();
    }

    public boolean isDisposed() {
        return ((Disposable)this.get()).isDisposed();
    }
}
