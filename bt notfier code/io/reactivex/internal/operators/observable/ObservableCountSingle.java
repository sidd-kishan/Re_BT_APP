/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.fuseable.FuseToObservable
 *  io.reactivex.internal.operators.observable.ObservableCount
 *  io.reactivex.internal.operators.observable.ObservableCountSingle$CountObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.observable.ObservableCount;
import io.reactivex.internal.operators.observable.ObservableCountSingle;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableCountSingle<T>
extends Single<Long>
implements FuseToObservable<Long> {
    final ObservableSource<T> source;

    public ObservableCountSingle(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    public Observable<Long> fuseToObservable() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableCount(this.source));
    }

    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.source.subscribe((Observer)new CountObserver(singleObserver));
    }
}
