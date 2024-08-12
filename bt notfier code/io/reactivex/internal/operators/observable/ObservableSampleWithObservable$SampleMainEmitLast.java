/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import java.util.concurrent.atomic.AtomicInteger;

static final class ObservableSampleWithObservable.SampleMainEmitLast<T>
extends ObservableSampleWithObservable.SampleMainObserver<T> {
    private static final long serialVersionUID = -3029755663834015785L;
    volatile boolean done;
    final AtomicInteger wip = new AtomicInteger();

    ObservableSampleWithObservable.SampleMainEmitLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
        super(observer, observableSource);
    }

    void completion() {
        this.done = true;
        if (this.wip.getAndIncrement() != 0) return;
        this.emit();
        this.downstream.onComplete();
    }

    void run() {
        if (this.wip.getAndIncrement() != 0) return;
        do {
            boolean bl = this.done;
            this.emit();
            if (!bl) continue;
            this.downstream.onComplete();
            return;
        } while (this.wip.decrementAndGet() != 0);
    }
}
