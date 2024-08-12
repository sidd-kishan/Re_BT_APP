/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther$DelayObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;

public final class ObservableDelaySubscriptionOther<T, U>
extends Observable<T> {
    final ObservableSource<? extends T> main;
    final ObservableSource<U> other;

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.main = observableSource;
        this.other = observableSource2;
    }

    public void subscribeActual(Observer<? super T> delayObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        delayObserver.onSubscribe((Disposable)sequentialDisposable);
        delayObserver = new DelayObserver(this, sequentialDisposable, delayObserver);
        this.other.subscribe((Observer)delayObserver);
    }
}
