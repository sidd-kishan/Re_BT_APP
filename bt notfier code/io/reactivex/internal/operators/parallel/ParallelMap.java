/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelMap$ParallelMapConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelMap$ParallelMapSubscriber
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.parallel.ParallelMap;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;

public final class ParallelMap<T, R>
extends ParallelFlowable<R> {
    final Function<? super T, ? extends R> mapper;
    final ParallelFlowable<T> source;

    public ParallelMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function) {
        this.source = parallelFlowable;
        this.mapper = function;
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
            Subscriber<? super R> subscriber = subscriberArray[n2];
            subscriberArray2[n2] = subscriber instanceof ConditionalSubscriber ? new ParallelMapConditionalSubscriber((ConditionalSubscriber)subscriber, this.mapper) : new ParallelMapSubscriber(subscriber, this.mapper);
            ++n2;
        }
    }
}
