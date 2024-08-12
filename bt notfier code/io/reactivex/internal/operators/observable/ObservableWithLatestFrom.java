/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableWithLatestFrom$WithLatestFromObserver
 *  io.reactivex.internal.operators.observable.ObservableWithLatestFrom$WithLatestFromOtherObserver
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.observers.SerializedObserver;

public final class ObservableWithLatestFrom<T, U, R>
extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final ObservableSource<? extends U> other;

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.combiner = biFunction;
        this.other = observableSource2;
    }

    public void subscribeActual(Observer<? super R> serializedObserver) {
        serializedObserver = new SerializedObserver(serializedObserver);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver((Observer)serializedObserver, this.combiner);
        serializedObserver.onSubscribe((Disposable)withLatestFromObserver);
        this.other.subscribe((Observer)new WithLatestFromOtherObserver(this, withLatestFromObserver));
        this.source.subscribe((Observer)withLatestFromObserver);
    }
}
