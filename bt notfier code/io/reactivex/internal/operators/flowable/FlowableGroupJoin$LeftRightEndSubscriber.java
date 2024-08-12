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

static final class FlowableGroupJoin.LeftRightEndSubscriber
extends AtomicReference<Subscription>
implements FlowableSubscriber<Object>,
Disposable {
    private static final long serialVersionUID = 1883890389173668373L;
    final int index;
    final boolean isLeft;
    final FlowableGroupJoin.JoinSupport parent;

    FlowableGroupJoin.LeftRightEndSubscriber(FlowableGroupJoin.JoinSupport joinSupport, boolean bl, int n) {
        this.parent = joinSupport;
        this.isLeft = bl;
        this.index = n;
    }

    public void dispose() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        this.parent.innerClose(this.isLeft, this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerCloseError(throwable);
    }

    public void onNext(Object object) {
        if (!SubscriptionHelper.cancel((AtomicReference)this)) return;
        this.parent.innerClose(this.isLeft, this);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
