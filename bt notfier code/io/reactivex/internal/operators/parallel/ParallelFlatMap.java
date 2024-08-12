/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.FlowableFlatMap
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelFlatMap<T, R>
extends ParallelFlowable<R> {
    final boolean delayError;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;
    final ParallelFlowable<T> source;

    public ParallelFlatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, boolean bl, int n, int n2) {
        this.source = parallelFlowable;
        this.mapper = function;
        this.delayError = bl;
        this.maxConcurrency = n;
        this.prefetch = n2;
    }

    public int parallelism() {
        return this.source.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArray) {
        if (!this.validate(subscriberArray)) {
            return;
        }
        int n = subscriberArray.length;
        Subscriber[] subscriberArray2 = new Subscriber[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.source.subscribe(subscriberArray2);
                return;
            }
            subscriberArray2[n2] = FlowableFlatMap.subscribe(subscriberArray[n2], this.mapper, (boolean)this.delayError, (int)this.maxConcurrency, (int)this.prefetch);
            ++n2;
        }
    }
}
