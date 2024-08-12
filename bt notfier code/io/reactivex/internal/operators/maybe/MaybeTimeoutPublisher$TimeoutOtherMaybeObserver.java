/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher$TimeoutMainMaybeObserver
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class MaybeTimeoutPublisher.TimeoutOtherMaybeObserver<T, U>
extends AtomicReference<Subscription>
implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = 8663801314800248617L;
    final MaybeTimeoutPublisher.TimeoutMainMaybeObserver<T, U> parent;

    MaybeTimeoutPublisher.TimeoutOtherMaybeObserver(MaybeTimeoutPublisher.TimeoutMainMaybeObserver<T, U> timeoutMainMaybeObserver) {
        this.parent = timeoutMainMaybeObserver;
    }

    public void onComplete() {
        this.parent.otherComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.otherError(throwable);
    }

    public void onNext(Object object) {
        ((Subscription)this.get()).cancel();
        this.parent.otherComplete();
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
