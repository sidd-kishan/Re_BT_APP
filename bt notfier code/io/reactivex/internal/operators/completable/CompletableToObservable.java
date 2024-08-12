/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.completable.CompletableToObservable$ObserverCompletableObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.operators.completable.CompletableToObservable;

public final class CompletableToObservable<T>
extends Observable<T> {
    final CompletableSource source;

    public CompletableToObservable(CompletableSource completableSource) {
        this.source = completableSource;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((CompletableObserver)new ObserverCompletableObserver(observer));
    }
}
