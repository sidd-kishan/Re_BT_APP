/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.single.SingleTakeUntil$TakeUntilMainObserver
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class SingleTakeUntil.TakeUntilOtherSubscriber
extends AtomicReference<Subscription>
implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = 5170026210238877381L;
    final SingleTakeUntil.TakeUntilMainObserver<?> parent;

    SingleTakeUntil.TakeUntilOtherSubscriber(SingleTakeUntil.TakeUntilMainObserver<?> takeUntilMainObserver) {
        this.parent = takeUntilMainObserver;
    }

    public void dispose() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public void onComplete() {
        if (this.get() == SubscriptionHelper.CANCELLED) return;
        this.lazySet(SubscriptionHelper.CANCELLED);
        this.parent.otherError((Throwable)new CancellationException());
    }

    public void onError(Throwable throwable) {
        this.parent.otherError(throwable);
    }

    public void onNext(Object object) {
        if (!SubscriptionHelper.cancel((AtomicReference)this)) return;
        this.parent.otherError((Throwable)new CancellationException());
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
