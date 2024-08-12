/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableSkipLast$SkipLastObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableSkipLast;

public final class ObservableSkipLast<T>
extends AbstractObservableWithUpstream<T, T> {
    final int skip;

    public ObservableSkipLast(ObservableSource<T> observableSource, int n) {
        super(observableSource);
        this.skip = n;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new SkipLastObserver(observer, this.skip));
    }
}
