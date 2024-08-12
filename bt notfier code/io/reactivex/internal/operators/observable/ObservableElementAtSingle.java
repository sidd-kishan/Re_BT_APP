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
 *  io.reactivex.internal.operators.observable.ObservableElementAt
 *  io.reactivex.internal.operators.observable.ObservableElementAtSingle$ElementAtObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.observable.ObservableElementAt;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableElementAtSingle<T>
extends Single<T>
implements FuseToObservable<T> {
    final T defaultValue;
    final long index;
    final ObservableSource<T> source;

    public ObservableElementAtSingle(ObservableSource<T> observableSource, long l, T t) {
        this.source = observableSource;
        this.index = l;
        this.defaultValue = t;
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableElementAt(this.source, this.index, this.defaultValue, true));
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((Observer)new ElementAtObserver(singleObserver, this.index, this.defaultValue));
    }
}
