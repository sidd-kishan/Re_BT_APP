/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.fuseable.FuseToObservable
 *  io.reactivex.internal.operators.observable.ObservableFlatMapCompletable
 *  io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableFlatMapCompletableCompletable<T>
extends Completable
implements FuseToObservable<T> {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final ObservableSource<T> source;

    public ObservableFlatMapCompletableCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean bl) {
        this.source = observableSource;
        this.mapper = function;
        this.delayErrors = bl;
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableFlatMapCompletable(this.source, this.mapper, this.delayErrors));
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((Observer)new FlatMapCompletableMainObserver(completableObserver, this.mapper, this.delayErrors));
    }
}
