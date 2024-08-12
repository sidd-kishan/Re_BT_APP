/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableOnErrorNext$OnErrorNextSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableOnErrorNext;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnErrorNext<T>
extends AbstractFlowableWithUpstream<T, T> {
    final boolean allowFatal;
    final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;

    public FlowableOnErrorNext(Flowable<T> flowable, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean bl) {
        super(flowable);
        this.nextSupplier = function;
        this.allowFatal = bl;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        OnErrorNextSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(subscriber, this.nextSupplier, this.allowFatal);
        subscriber.onSubscribe((Subscription)onErrorNextSubscriber);
        this.source.subscribe((FlowableSubscriber)onErrorNextSubscriber);
    }
}
