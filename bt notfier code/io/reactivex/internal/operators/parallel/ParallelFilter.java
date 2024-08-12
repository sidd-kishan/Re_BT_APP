/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelFilter$ParallelFilterConditionalSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelFilter$ParallelFilterSubscriber
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.parallel.ParallelFilter;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;

public final class ParallelFilter<T>
extends ParallelFlowable<T> {
    final Predicate<? super T> predicate;
    final ParallelFlowable<T> source;

    public ParallelFilter(ParallelFlowable<T> parallelFlowable, Predicate<? super T> predicate) {
        this.source = parallelFlowable;
        this.predicate = predicate;
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
            subscriberArray2[n2] = subscriber instanceof ConditionalSubscriber ? new ParallelFilterConditionalSubscriber((ConditionalSubscriber)subscriber, this.predicate) : new ParallelFilterSubscriber(subscriber, this.predicate);
            ++n2;
        }
    }
}
