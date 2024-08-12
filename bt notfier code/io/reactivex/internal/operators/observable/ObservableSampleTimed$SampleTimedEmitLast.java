/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableSampleTimed.SampleTimedEmitLast<T>
extends ObservableSampleTimed.SampleTimedObserver<T> {
    private static final long serialVersionUID = -7139995637533111443L;
    final AtomicInteger wip = new AtomicInteger(1);

    ObservableSampleTimed.SampleTimedEmitLast(Observer<? super T> observer, long l, TimeUnit timeUnit, Scheduler scheduler) {
        super(observer, l, timeUnit, scheduler);
    }

    void complete() {
        this.emit();
        if (this.wip.decrementAndGet() != 0) return;
        this.downstream.onComplete();
    }

    public void run() {
        if (this.wip.incrementAndGet() != 2) return;
        this.emit();
        if (this.wip.decrementAndGet() != 0) return;
        this.downstream.onComplete();
    }
}
