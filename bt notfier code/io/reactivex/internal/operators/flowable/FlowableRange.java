/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableRange$RangeConditionalSubscription
 *  io.reactivex.internal.operators.flowable.FlowableRange$RangeSubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.FlowableRange;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRange
extends Flowable<Integer> {
    final int end;
    final int start;

    public FlowableRange(int n, int n2) {
        this.start = n;
        this.end = n + n2;
    }

    public void subscribeActual(Subscriber<? super Integer> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe((Subscription)new RangeConditionalSubscription((ConditionalSubscriber)subscriber, this.start, this.end));
        } else {
            subscriber.onSubscribe((Subscription)new RangeSubscription(subscriber, this.start, this.end));
        }
    }
}
