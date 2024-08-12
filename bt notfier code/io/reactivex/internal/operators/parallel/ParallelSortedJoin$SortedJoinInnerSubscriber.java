/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.parallel.ParallelSortedJoin$SortedJoinSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class ParallelSortedJoin.SortedJoinInnerSubscriber<T>
extends AtomicReference<Subscription>
implements FlowableSubscriber<List<T>> {
    private static final long serialVersionUID = 6751017204873808094L;
    final int index;
    final ParallelSortedJoin.SortedJoinSubscription<T> parent;

    ParallelSortedJoin.SortedJoinInnerSubscriber(ParallelSortedJoin.SortedJoinSubscription<T> sortedJoinSubscription, int n) {
        this.parent = sortedJoinSubscription;
        this.index = n;
    }

    void cancel() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(throwable);
    }

    public void onNext(List<T> list) {
        this.parent.innerNext(list, this.index);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
