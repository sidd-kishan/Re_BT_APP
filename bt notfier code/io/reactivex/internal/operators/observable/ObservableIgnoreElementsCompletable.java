/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.fuseable.FuseToObservable
 *  io.reactivex.internal.operators.observable.ObservableIgnoreElements
 *  io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable$IgnoreObservable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.observable.ObservableIgnoreElements;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableIgnoreElementsCompletable<T>
extends Completable
implements FuseToObservable<T> {
    final ObservableSource<T> source;

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableIgnoreElements(this.source));
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((Observer)new IgnoreObservable(completableObserver));
    }
}
