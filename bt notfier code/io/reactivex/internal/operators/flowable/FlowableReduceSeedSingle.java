/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle$ReduceSeedObserver
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableReduceSeedSingle<T, R>
extends Single<R> {
    final BiFunction<R, ? super T, R> reducer;
    final R seed;
    final Publisher<T> source;

    public FlowableReduceSeedSingle(Publisher<T> publisher, R r, BiFunction<R, ? super T, R> biFunction) {
        this.source = publisher;
        this.seed = r;
        this.reducer = biFunction;
    }

    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe((Subscriber)new ReduceSeedObserver(singleObserver, this.reducer, this.seed));
    }
}
