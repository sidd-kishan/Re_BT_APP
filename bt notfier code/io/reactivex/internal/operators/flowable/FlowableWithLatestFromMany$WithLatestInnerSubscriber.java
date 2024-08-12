/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany$WithLatestFromSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowableWithLatestFromMany.WithLatestInnerSubscriber
extends AtomicReference<Subscription>
implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = 3256684027868224024L;
    boolean hasValue;
    final int index;
    final FlowableWithLatestFromMany.WithLatestFromSubscriber<?, ?> parent;

    FlowableWithLatestFromMany.WithLatestInnerSubscriber(FlowableWithLatestFromMany.WithLatestFromSubscriber<?, ?> withLatestFromSubscriber, int n) {
        this.parent = withLatestFromSubscriber;
        this.index = n;
    }

    void dispose() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public void onComplete() {
        this.parent.innerComplete(this.index, this.hasValue);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(this.index, throwable);
    }

    public void onNext(Object object) {
        if (!this.hasValue) {
            this.hasValue = true;
        }
        this.parent.innerNext(this.index, object);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
