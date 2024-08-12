/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.completable.CompletableFromObservable$CompletableFromObservableObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.completable.CompletableFromObservable;

public final class CompletableFromObservable<T>
extends Completable {
    final ObservableSource<T> observable;

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.observable = observableSource;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.observable.subscribe((Observer)new CompletableFromObservableObserver(completableObserver));
    }
}
