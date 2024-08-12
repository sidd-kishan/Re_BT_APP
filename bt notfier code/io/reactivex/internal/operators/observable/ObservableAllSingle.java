/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.fuseable.FuseToObservable
 *  io.reactivex.internal.operators.observable.ObservableAll
 *  io.reactivex.internal.operators.observable.ObservableAllSingle$AllObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.observable.ObservableAll;
import io.reactivex.internal.operators.observable.ObservableAllSingle;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAllSingle<T>
extends Single<Boolean>
implements FuseToObservable<Boolean> {
    final Predicate<? super T> predicate;
    final ObservableSource<T> source;

    public ObservableAllSingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.source = observableSource;
        this.predicate = predicate;
    }

    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableAll(this.source, this.predicate));
    }

    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe((Observer)new AllObserver(singleObserver, this.predicate));
    }
}
