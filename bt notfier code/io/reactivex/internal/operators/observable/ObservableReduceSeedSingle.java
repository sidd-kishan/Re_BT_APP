/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.operators.observable.ObservableReduceSeedSingle$ReduceSeedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;

public final class ObservableReduceSeedSingle<T, R>
extends Single<R> {
    final BiFunction<R, ? super T, R> reducer;
    final R seed;
    final ObservableSource<T> source;

    public ObservableReduceSeedSingle(ObservableSource<T> observableSource, R r, BiFunction<R, ? super T, R> biFunction) {
        this.source = observableSource;
        this.seed = r;
        this.reducer = biFunction;
    }

    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe((Observer)new ReduceSeedObserver(singleObserver, this.reducer, this.seed));
    }
}
