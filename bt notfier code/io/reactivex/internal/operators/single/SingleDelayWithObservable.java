/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.single.SingleDelayWithObservable$OtherSubscriber
 */
package io.reactivex.internal.operators.single;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;

public final class SingleDelayWithObservable<T, U>
extends Single<T> {
    final ObservableSource<U> other;
    final SingleSource<T> source;

    public SingleDelayWithObservable(SingleSource<T> singleSource, ObservableSource<U> observableSource) {
        this.source = singleSource;
        this.other = observableSource;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.other.subscribe((Observer)new OtherSubscriber(singleObserver, this.source));
    }
}
