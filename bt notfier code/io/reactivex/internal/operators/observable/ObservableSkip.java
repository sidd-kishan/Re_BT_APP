/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableSkip$SkipObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableSkip;

public final class ObservableSkip<T>
extends AbstractObservableWithUpstream<T, T> {
    final long n;

    public ObservableSkip(ObservableSource<T> observableSource, long l) {
        super(observableSource);
        this.n = l;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new SkipObserver(observer, this.n));
    }
}
