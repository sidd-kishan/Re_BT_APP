/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class MaybeTakeUntilPublisher.TakeUntilMainMaybeObserver.TakeUntilOtherMaybeObserver<U>
extends AtomicReference<Subscription>
implements FlowableSubscriber<U> {
    private static final long serialVersionUID = -1266041316834525931L;
    final MaybeTakeUntilPublisher.TakeUntilMainMaybeObserver<?, U> parent;

    MaybeTakeUntilPublisher.TakeUntilMainMaybeObserver.TakeUntilOtherMaybeObserver(MaybeTakeUntilPublisher.TakeUntilMainMaybeObserver<?, U> takeUntilMainMaybeObserver) {
        this.parent = takeUntilMainMaybeObserver;
    }

    public void onComplete() {
        this.parent.otherComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.otherError(throwable);
    }

    public void onNext(Object object) {
        SubscriptionHelper.cancel((AtomicReference)this);
        this.parent.otherComplete();
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
