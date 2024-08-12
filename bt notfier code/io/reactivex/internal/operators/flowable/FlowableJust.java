/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.internal.fuseable.ScalarCallable
 *  io.reactivex.internal.subscriptions.ScalarSubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableJust<T>
extends Flowable<T>
implements ScalarCallable<T> {
    private final T value;

    public FlowableJust(T t) {
        this.value = t;
    }

    public T call() {
        return this.value;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        subscriber.onSubscribe((Subscription)new ScalarSubscription(subscriber, this.value));
    }
}
