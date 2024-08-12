/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableAmb$AmbInnerSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableAmb;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableAmb.AmbCoordinator<T>
implements Subscription {
    final Subscriber<? super T> downstream;
    final FlowableAmb.AmbInnerSubscriber<T>[] subscribers;
    final AtomicInteger winner = new AtomicInteger();

    FlowableAmb.AmbCoordinator(Subscriber<? super T> subscriber, int n) {
        this.downstream = subscriber;
        this.subscribers = new FlowableAmb.AmbInnerSubscriber[n];
    }

    public void cancel() {
        if (this.winner.get() == -1) return;
        this.winner.lazySet(-1);
        FlowableAmb.AmbInnerSubscriber<T>[] ambInnerSubscriberArray = this.subscribers;
        int n = ambInnerSubscriberArray.length;
        int n2 = 0;
        while (n2 < n) {
            ambInnerSubscriberArray[n2].cancel();
            ++n2;
        }
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        int n = this.winner.get();
        if (n > 0) {
            this.subscribers[n - 1].request(l);
            return;
        }
        if (n != 0) return;
        FlowableAmb.AmbInnerSubscriber<T>[] ambInnerSubscriberArray = this.subscribers;
        int n2 = ambInnerSubscriberArray.length;
        n = 0;
        while (n < n2) {
            ambInnerSubscriberArray[n].request(l);
            ++n;
        }
    }

    public void subscribe(Publisher<? extends T>[] publisherArray) {
        FlowableAmb.AmbInnerSubscriber<T>[] ambInnerSubscriberArray = this.subscribers;
        int n = ambInnerSubscriberArray.length;
        int n2 = 0;
        int n3 = 0;
        while (n3 < n) {
            int n4 = n3 + 1;
            ambInnerSubscriberArray[n3] = new FlowableAmb.AmbInnerSubscriber(this, n4, this.downstream);
            n3 = n4;
        }
        this.winner.lazySet(0);
        this.downstream.onSubscribe((Subscription)this);
        n3 = n2;
        while (n3 < n) {
            if (this.winner.get() != 0) {
                return;
            }
            publisherArray[n3].subscribe(ambInnerSubscriberArray[n3]);
            ++n3;
        }
    }

    public boolean win(int n) {
        int n2 = this.winner.get();
        int n3 = 0;
        if (n2 != 0) return false;
        if (!this.winner.compareAndSet(0, n)) return false;
        FlowableAmb.AmbInnerSubscriber<T>[] ambInnerSubscriberArray = this.subscribers;
        int n4 = ambInnerSubscriberArray.length;
        while (n3 < n4) {
            n2 = n3 + 1;
            if (n2 != n) {
                ambInnerSubscriberArray[n3].cancel();
            }
            n3 = n2;
        }
        return true;
    }
}
