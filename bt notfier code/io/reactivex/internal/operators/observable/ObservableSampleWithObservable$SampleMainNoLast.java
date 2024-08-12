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

static final class ObservableSampleWithObservable.SampleMainNoLast<T>
extends ObservableSampleWithObservable.SampleMainObserver<T> {
    private static final long serialVersionUID = -3029755663834015785L;

    ObservableSampleWithObservable.SampleMainNoLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
        super(observer, observableSource);
    }

    void completion() {
        this.downstream.onComplete();
    }

    void run() {
        this.emit();
    }
}
