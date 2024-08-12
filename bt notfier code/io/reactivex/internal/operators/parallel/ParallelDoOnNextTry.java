/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelDoOnNextTry$ParallelDoOnNextConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelDoOnNextTry$ParallelDoOnNextSubscriber
 *  io.reactivex.parallel.ParallelFailureHandling
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.parallel.ParallelDoOnNextTry;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;

public final class ParallelDoOnNextTry<T>
extends ParallelFlowable<T> {
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Consumer<? super T> onNext;
    final ParallelFlowable<T> source;

    public ParallelDoOnNextTry(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.source = parallelFlowable;
        this.onNext = consumer;
        this.errorHandler = biFunction;
    }

    public int parallelism() {
        return this.source.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArray) {
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
            Subscriber<? super T> subscriber = subscriberArray[n2];
            subscriberArray2[n2] = subscriber instanceof ConditionalSubscriber ? new ParallelDoOnNextConditionalSubscriber((ConditionalSubscriber)subscriber, this.onNext, this.errorHandler) : new ParallelDoOnNextSubscriber(subscriber, this.onNext, this.errorHandler);
            ++n2;
        }
    }
}
