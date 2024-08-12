/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.mixed.SingleFlatMapObservable$FlatMapObserver
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable;

public final class SingleFlatMapObservable<T, R>
extends Observable<R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final SingleSource<T> source;

    public SingleFlatMapObservable(SingleSource<T> singleSource, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.source = singleSource;
        this.mapper = function;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(observer, this.mapper);
        observer.onSubscribe((Disposable)flatMapObserver);
        this.source.subscribe((SingleObserver)flatMapObserver);
    }
}
