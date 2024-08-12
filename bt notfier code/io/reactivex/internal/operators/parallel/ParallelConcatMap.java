/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableConcatMap
 *  io.reactivex.internal.util.ErrorMode
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelConcatMap<T, R>
extends ParallelFlowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;
    final ParallelFlowable<T> source;

    public ParallelConcatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, int n, ErrorMode errorMode) {
        this.source = parallelFlowable;
        this.mapper = (Function)ObjectHelper.requireNonNull(function, (String)"mapper");
        this.prefetch = n;
        this.errorMode = (ErrorMode)ObjectHelper.requireNonNull((Object)errorMode, (String)"errorMode");
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
            subscriberArray2[n2] = FlowableConcatMap.subscribe(subscriberArray[n2], this.mapper, (int)this.prefetch, (ErrorMode)this.errorMode);
            ++n2;
        }
    }
}
