/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.operators.parallel.ParallelReduceFull$ParallelReduceFullMainSubscriber
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.operators.parallel.ParallelReduceFull;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelReduceFull<T>
extends Flowable<T> {
    final BiFunction<T, T, T> reducer;
    final ParallelFlowable<? extends T> source;

    public ParallelReduceFull(ParallelFlowable<? extends T> parallelFlowable, BiFunction<T, T, T> biFunction) {
        this.source = parallelFlowable;
        this.reducer = biFunction;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new ParallelReduceFullMainSubscriber(subscriber, this.source.parallelism(), this.reducer);
        subscriber.onSubscribe((Subscription)parallelReduceFullMainSubscriber);
        this.source.subscribe((Subscriber[])parallelReduceFullMainSubscriber.subscribers);
    }
}
