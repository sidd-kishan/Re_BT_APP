/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableFromArray$ArrayConditionalSubscription
 *  io.reactivex.internal.operators.flowable.FlowableFromArray$ArraySubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromArray<T>
extends Flowable<T> {
    final T[] array;

    public FlowableFromArray(T[] TArray) {
        this.array = TArray;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe((Subscription)new ArrayConditionalSubscription((ConditionalSubscriber)subscriber, (Object[])this.array));
        } else {
            subscriber.onSubscribe((Subscription)new ArraySubscription(subscriber, (Object[])this.array));
        }
    }
}
