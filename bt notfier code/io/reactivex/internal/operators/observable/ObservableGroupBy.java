/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableGroupBy$GroupByObserver
 *  io.reactivex.observables.GroupedObservable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.observables.GroupedObservable;

public final class ObservableGroupBy<T, K, V>
extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final Function<? super T, ? extends K> keySelector;
    final Function<? super T, ? extends V> valueSelector;

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int n, boolean bl) {
        super(observableSource);
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = n;
        this.delayError = bl;
    }

    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.source.subscribe((Observer)new GroupByObserver(observer, this.keySelector, this.valueSelector, this.bufferSize, this.delayError));
    }
}
