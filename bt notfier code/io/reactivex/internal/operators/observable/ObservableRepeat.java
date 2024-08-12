/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableRepeat$RepeatObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableRepeat;

public final class ObservableRepeat<T>
extends AbstractObservableWithUpstream<T, T> {
    final long count;

    public ObservableRepeat(Observable<T> observable, long l) {
        super(observable);
        this.count = l;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe((Disposable)sequentialDisposable);
        long l = this.count;
        long l2 = Long.MAX_VALUE;
        if (l != Long.MAX_VALUE) {
            l2 = l - 1L;
        }
        new RepeatObserver(observer, l2, sequentialDisposable, this.source).subscribeNext();
    }
}
