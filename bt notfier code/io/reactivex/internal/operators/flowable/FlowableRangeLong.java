/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableRangeLong$RangeConditionalSubscription
 *  io.reactivex.internal.operators.flowable.FlowableRangeLong$RangeSubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.FlowableRangeLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRangeLong
extends Flowable<Long> {
    final long end;
    final long start;

    public FlowableRangeLong(long l, long l2) {
        this.start = l;
        this.end = l + l2;
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe((Subscription)new RangeConditionalSubscription((ConditionalSubscriber)subscriber, this.start, this.end));
        } else {
            subscriber.onSubscribe((Subscription)new RangeSubscription(subscriber, this.start, this.end));
        }
    }
}
