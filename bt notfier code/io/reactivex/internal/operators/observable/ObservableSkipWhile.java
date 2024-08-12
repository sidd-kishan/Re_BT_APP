/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableSkipWhile$SkipWhileObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableSkipWhile;

public final class ObservableSkipWhile<T>
extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    public ObservableSkipWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.predicate = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new SkipWhileObserver(observer, this.predicate));
    }
}
