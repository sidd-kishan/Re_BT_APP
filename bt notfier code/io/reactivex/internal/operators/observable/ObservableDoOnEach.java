/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableDoOnEach$DoOnEachObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;

public final class ObservableDoOnEach<T>
extends AbstractObservableWithUpstream<T, T> {
    final Action onAfterTerminate;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;

    public ObservableDoOnEach(ObservableSource<T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(observableSource);
        this.onNext = consumer;
        this.onError = consumer2;
        this.onComplete = action;
        this.onAfterTerminate = action2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new DoOnEachObserver(observer, this.onNext, this.onError, this.onComplete, this.onAfterTerminate));
    }
}
