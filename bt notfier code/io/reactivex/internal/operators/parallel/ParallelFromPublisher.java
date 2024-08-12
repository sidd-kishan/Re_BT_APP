/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.parallel.ParallelFromPublisher$ParallelDispatcher
 *  io.reactivex.parallel.ParallelFlowable
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelFromPublisher<T>
extends ParallelFlowable<T> {
    final int parallelism;
    final int prefetch;
    final Publisher<? extends T> source;

    public ParallelFromPublisher(Publisher<? extends T> publisher, int n, int n2) {
        this.source = publisher;
        this.parallelism = n;
        this.prefetch = n2;
    }

    public int parallelism() {
        return this.parallelism;
    }

    public void subscribe(Subscriber<? super T>[] subscriberArray) {
        if (!this.validate(subscriberArray)) {
            return;
        }
        this.source.subscribe((Subscriber)new ParallelDispatcher(subscriberArray, this.prefetch));
    }
}
