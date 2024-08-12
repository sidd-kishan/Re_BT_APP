/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableAny$AnyObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableAny;

public final class ObservableAny<T>
extends AbstractObservableWithUpstream<T, Boolean> {
    final Predicate<? super T> predicate;

    public ObservableAny(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.predicate = predicate;
    }

    protected void subscribeActual(Observer<? super Boolean> observer) {
        this.source.subscribe((Observer)new AnyObserver(observer, this.predicate));
    }
}
