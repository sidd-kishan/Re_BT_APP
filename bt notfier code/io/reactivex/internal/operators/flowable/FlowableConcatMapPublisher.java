/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.FlowableConcatMap
 *  io.reactivex.internal.operators.flowable.FlowableScalarXMap
 *  io.reactivex.internal.util.ErrorMode
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapPublisher<T, R>
extends Flowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;
    final Publisher<T> source;

    public FlowableConcatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int n, ErrorMode errorMode) {
        this.source = publisher;
        this.mapper = function;
        this.prefetch = n;
        this.errorMode = errorMode;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            return;
        }
        this.source.subscribe(FlowableConcatMap.subscribe(subscriber, this.mapper, (int)this.prefetch, (ErrorMode)this.errorMode));
    }
}
