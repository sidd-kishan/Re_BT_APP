/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableWithLatestFrom$FlowableWithLatestSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableWithLatestFrom$WithLatestFromSubscriber
 *  io.reactivex.subscribers.SerializedSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom;
import io.reactivex.subscribers.SerializedSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFrom<T, U, R>
extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final Publisher<? extends U> other;

    public FlowableWithLatestFrom(Flowable<T> flowable, BiFunction<? super T, ? super U, ? extends R> biFunction, Publisher<? extends U> publisher) {
        super(flowable);
        this.combiner = biFunction;
        this.other = publisher;
    }

    protected void subscribeActual(Subscriber<? super R> withLatestFromSubscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(withLatestFromSubscriber);
        withLatestFromSubscriber = new WithLatestFromSubscriber((Subscriber)serializedSubscriber, this.combiner);
        serializedSubscriber.onSubscribe((Subscription)withLatestFromSubscriber);
        this.other.subscribe((Subscriber)new FlowableWithLatestSubscriber(this, withLatestFromSubscriber));
        this.source.subscribe((FlowableSubscriber)withLatestFromSubscriber);
    }
}
