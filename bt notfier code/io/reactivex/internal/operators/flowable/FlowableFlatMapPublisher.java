/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.FlowableFlatMap
 *  io.reactivex.internal.operators.flowable.FlowableScalarXMap
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableScalarXMap;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableFlatMapPublisher<T, U>
extends Flowable<U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends U>> mapper;
    final int maxConcurrency;
    final Publisher<T> source;

    public FlowableFlatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends U>> function, boolean bl, int n, int n2) {
        this.source = publisher;
        this.mapper = function;
        this.delayErrors = bl;
        this.maxConcurrency = n;
        this.bufferSize = n2;
    }

    protected void subscribeActual(Subscriber<? super U> subscriber) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            return;
        }
        this.source.subscribe((Subscriber)FlowableFlatMap.subscribe(subscriber, this.mapper, (boolean)this.delayErrors, (int)this.maxConcurrency, (int)this.bufferSize));
    }
}
