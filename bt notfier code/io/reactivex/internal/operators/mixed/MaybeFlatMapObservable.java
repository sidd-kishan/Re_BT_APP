/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.mixed.MaybeFlatMapObservable$FlatMapObserver
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.mixed.MaybeFlatMapObservable;

public final class MaybeFlatMapObservable<T, R>
extends Observable<R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapObservable(MaybeSource<T> maybeSource, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.source = maybeSource;
        this.mapper = function;
    }

    protected void subscribeActual(Observer<? super R> observer) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(observer, this.mapper);
        observer.onSubscribe((Disposable)flatMapObserver);
        this.source.subscribe((MaybeObserver)flatMapObserver);
    }
}
