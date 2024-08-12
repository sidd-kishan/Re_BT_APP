/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableSource
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableFlatMapCompletable$FlatMapCompletableMainObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletable;

public final class ObservableFlatMapCompletable<T>
extends AbstractObservableWithUpstream<T, T> {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;

    public ObservableFlatMapCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean bl) {
        super(observableSource);
        this.mapper = function;
        this.delayErrors = bl;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new FlatMapCompletableMainObserver(observer, this.mapper, this.delayErrors));
    }
}
