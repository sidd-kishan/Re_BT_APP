/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelMapTry$ParallelMapTryConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelMapTry$ParallelMapTrySubscriber
 *  io.reactivex.parallel.ParallelFailureHandling
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.parallel.ParallelMapTry;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;

public final class ParallelMapTry<T, R>
extends ParallelFlowable<R> {
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Function<? super T, ? extends R> mapper;
    final ParallelFlowable<T> source;

    public ParallelMapTry(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.source = parallelFlowable;
        this.mapper = function;
        this.errorHandler = biFunction;
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
            subscriberArray2[n2] = subscriber instanceof ConditionalSubscriber ? new ParallelMapTryConditionalSubscriber((ConditionalSubscriber)subscriber, this.mapper, this.errorHandler) : new ParallelMapTrySubscriber(subscriber, this.mapper, this.errorHandler);
            ++n2;
        }
    }
}
