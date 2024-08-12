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
 *  io.reactivex.internal.operators.observable.ObservableAny
 *  io.reactivex.internal.operators.observable.ObservableAnySingle$AnyObserver
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
import io.reactivex.internal.operators.observable.ObservableAny;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAnySingle<T>
extends Single<Boolean>
implements FuseToObservable<Boolean> {
    final Predicate<? super T> predicate;
    final ObservableSource<T> source;

    public ObservableAnySingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.source = observableSource;
        this.predicate = predicate;
    }

    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableAny(this.source, this.predicate));
    }

    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe((Observer)new AnyObserver(singleObserver, this.predicate));
    }
}
