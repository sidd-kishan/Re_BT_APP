/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.EndConsumerHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

public abstract class DefaultSubscriber<T>
implements FlowableSubscriber<T> {
    Subscription upstream;

    protected final void cancel() {
        Subscription subscription = this.upstream;
        this.upstream = SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }

    protected void onStart() {
        this.request(Long.MAX_VALUE);
    }

    public final void onSubscribe(Subscription subscription) {
        if (!EndConsumerHelper.validate((Subscription)this.upstream, (Subscription)subscription, this.getClass())) return;
        this.upstream = subscription;
        this.onStart();
    }

    protected final void request(long l) {
        Subscription subscription = this.upstream;
        if (subscription == null) return;
        subscription.request(l);
    }
}
