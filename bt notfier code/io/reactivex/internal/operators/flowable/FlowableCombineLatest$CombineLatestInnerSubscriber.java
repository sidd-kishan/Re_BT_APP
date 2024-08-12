/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableCombineLatest$CombineLatestCoordinator
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowableCombineLatest.CombineLatestInnerSubscriber<T>
extends AtomicReference<Subscription>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -8730235182291002949L;
    final int index;
    final int limit;
    final FlowableCombineLatest.CombineLatestCoordinator<T, ?> parent;
    final int prefetch;
    int produced;

    FlowableCombineLatest.CombineLatestInnerSubscriber(FlowableCombineLatest.CombineLatestCoordinator<T, ?> combineLatestCoordinator, int n, int n2) {
        this.parent = combineLatestCoordinator;
        this.index = n;
        this.prefetch = n2;
        this.limit = n2 - (n2 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(this.index, throwable);
    }

    public void onNext(T t) {
        this.parent.innerValue(this.index, t);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)this.prefetch);
    }

    public void requestOne() {
        int n = this.produced + 1;
        if (n == this.limit) {
            this.produced = 0;
            ((Subscription)this.get()).request((long)n);
        } else {
            this.produced = n;
        }
    }
}
