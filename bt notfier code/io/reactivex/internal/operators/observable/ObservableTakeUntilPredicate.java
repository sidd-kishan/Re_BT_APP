/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate$TakeUntilPredicateObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate;

public final class ObservableTakeUntilPredicate<T>
extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    public ObservableTakeUntilPredicate(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.predicate = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new TakeUntilPredicateObserver(observer, this.predicate));
    }
}
