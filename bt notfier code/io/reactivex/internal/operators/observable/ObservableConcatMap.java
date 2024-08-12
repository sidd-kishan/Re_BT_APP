/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver
 *  io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver
 *  io.reactivex.internal.operators.observable.ObservableScalarXMap
 *  io.reactivex.internal.util.ErrorMode
 *  io.reactivex.observers.SerializedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observers.SerializedObserver;

public final class ObservableConcatMap<T, U>
extends AbstractObservableWithUpstream<T, U> {
    final int bufferSize;
    final ErrorMode delayErrors;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int n, ErrorMode errorMode) {
        super(observableSource);
        this.mapper = function;
        this.delayErrors = errorMode;
        this.bufferSize = Math.max(8, n);
    }

    public void subscribeActual(Observer<? super U> serializedObserver) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe((ObservableSource)this.source, serializedObserver, this.mapper)) {
            return;
        }
        if (this.delayErrors == ErrorMode.IMMEDIATE) {
            serializedObserver = new SerializedObserver(serializedObserver);
            this.source.subscribe((Observer)new SourceObserver((Observer)serializedObserver, this.mapper, this.bufferSize));
        } else {
            ObservableSource observableSource = this.source;
            Function<? super T, ? extends ObservableSource<? extends U>> function = this.mapper;
            int n = this.bufferSize;
            boolean bl = this.delayErrors == ErrorMode.END;
            observableSource.subscribe((Observer)new ConcatMapDelayErrorObserver((Observer)serializedObserver, function, n, bl));
        }
    }
}
