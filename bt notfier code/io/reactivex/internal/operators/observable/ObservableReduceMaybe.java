/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.operators.observable.ObservableReduceMaybe$ReduceObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.operators.observable.ObservableReduceMaybe;

public final class ObservableReduceMaybe<T>
extends Maybe<T> {
    final BiFunction<T, T, T> reducer;
    final ObservableSource<T> source;

    public ObservableReduceMaybe(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        this.source = observableSource;
        this.reducer = biFunction;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((Observer)new ReduceObserver(maybeObserver, this.reducer));
    }
}
