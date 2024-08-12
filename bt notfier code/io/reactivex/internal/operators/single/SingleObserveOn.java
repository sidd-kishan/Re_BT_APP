/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.single.SingleObserveOn$ObserveOnSingleObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.single.SingleObserveOn;

public final class SingleObserveOn<T>
extends Single<T> {
    final Scheduler scheduler;
    final SingleSource<T> source;

    public SingleObserveOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.source = singleSource;
        this.scheduler = scheduler;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((SingleObserver)new ObserveOnSingleObserver(singleObserver, this.scheduler));
    }
}
