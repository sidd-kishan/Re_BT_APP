/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionArbiter
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableSwitchIfEmpty.SwitchIfEmptySubscriber<T>
implements FlowableSubscriber<T> {
    final SubscriptionArbiter arbiter;
    final Subscriber<? super T> downstream;
    boolean empty;
    final Publisher<? extends T> other;

    FlowableSwitchIfEmpty.SwitchIfEmptySubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
        this.downstream = subscriber;
        this.other = publisher;
        this.empty = true;
        this.arbiter = new SubscriptionArbiter(false);
    }

    public void onComplete() {
        if (this.empty) {
            this.empty = false;
            this.other.subscribe((Subscriber)this);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.empty) {
            this.empty = false;
        }
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        this.arbiter.setSubscription(subscription);
    }
}
