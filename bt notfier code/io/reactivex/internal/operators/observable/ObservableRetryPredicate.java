/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableRetryPredicate$RepeatObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;

public final class ObservableRetryPredicate<T>
extends AbstractObservableWithUpstream<T, T> {
    final long count;
    final Predicate<? super Throwable> predicate;

    public ObservableRetryPredicate(Observable<T> observable, long l, Predicate<? super Throwable> predicate) {
        super(observable);
        this.predicate = predicate;
        this.count = l;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe((Disposable)sequentialDisposable);
        new RepeatObserver(observer, this.count, this.predicate, sequentialDisposable, this.source).subscribeNext();
    }
}
