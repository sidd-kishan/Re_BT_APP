/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableConcatMap.WeakScalarSubscription<T>
implements Subscription {
    final Subscriber<? super T> downstream;
    boolean once;
    final T value;

    FlowableConcatMap.WeakScalarSubscription(T t, Subscriber<? super T> subscriber) {
        this.value = t;
        this.downstream = subscriber;
    }

    public void cancel() {
    }

    public void request(long l) {
        if (l <= 0L) return;
        if (this.once) return;
        this.once = true;
        Subscriber<? super T> subscriber = this.downstream;
        subscriber.onNext(this.value);
        subscriber.onComplete();
    }
}
