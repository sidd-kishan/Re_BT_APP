/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.ObservableGroupBy$GroupByObserver
 *  io.reactivex.internal.operators.observable.ObservableGroupBy$State
 *  io.reactivex.observables.GroupedObservable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.observables.GroupedObservable;

static final class ObservableGroupBy.GroupedUnicast<K, T>
extends GroupedObservable<K, T> {
    final ObservableGroupBy.State<T, K> state;

    protected ObservableGroupBy.GroupedUnicast(K k, ObservableGroupBy.State<T, K> state) {
        super(k);
        this.state = state;
    }

    public static <T, K> ObservableGroupBy.GroupedUnicast<K, T> createWith(K k, int n, ObservableGroupBy.GroupByObserver<?, K, T> groupByObserver, boolean bl) {
        return new ObservableGroupBy.GroupedUnicast<K, T>(k, new ObservableGroupBy.State(n, groupByObserver, k, bl));
    }

    public void onComplete() {
        this.state.onComplete();
    }

    public void onError(Throwable throwable) {
        this.state.onError(throwable);
    }

    public void onNext(T t) {
        this.state.onNext(t);
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.state.subscribe(observer);
    }
}
