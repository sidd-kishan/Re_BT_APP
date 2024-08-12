/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.flowable.FlowableGroupJoin$JoinSupport
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowableGroupJoin.LeftRightSubscriber
extends AtomicReference<Subscription>
implements FlowableSubscriber<Object>,
Disposable {
    private static final long serialVersionUID = 1883890389173668373L;
    final boolean isLeft;
    final FlowableGroupJoin.JoinSupport parent;

    FlowableGroupJoin.LeftRightSubscriber(FlowableGroupJoin.JoinSupport joinSupport, boolean bl) {
        this.parent = joinSupport;
        this.isLeft = bl;
    }

    public void dispose() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(throwable);
    }

    public void onNext(Object object) {
        this.parent.innerValue(this.isLeft, object);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
