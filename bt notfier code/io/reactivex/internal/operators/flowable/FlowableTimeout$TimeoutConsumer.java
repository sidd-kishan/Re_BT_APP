/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.flowable.FlowableTimeout$TimeoutSelectorSupport
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.flowable.FlowableTimeout;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowableTimeout.TimeoutConsumer
extends AtomicReference<Subscription>
implements FlowableSubscriber<Object>,
Disposable {
    private static final long serialVersionUID = 8708641127342403073L;
    final long idx;
    final FlowableTimeout.TimeoutSelectorSupport parent;

    FlowableTimeout.TimeoutConsumer(long l, FlowableTimeout.TimeoutSelectorSupport timeoutSelectorSupport) {
        this.idx = l;
        this.parent = timeoutSelectorSupport;
    }

    public void dispose() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        if (this.get() == SubscriptionHelper.CANCELLED) return;
        this.lazySet(SubscriptionHelper.CANCELLED);
        this.parent.onTimeout(this.idx);
    }

    public void onError(Throwable throwable) {
        if (this.get() != SubscriptionHelper.CANCELLED) {
            this.lazySet(SubscriptionHelper.CANCELLED);
            this.parent.onTimeoutError(this.idx, throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(Object object) {
        object = (Subscription)this.get();
        if (object == SubscriptionHelper.CANCELLED) return;
        object.cancel();
        this.lazySet(SubscriptionHelper.CANCELLED);
        this.parent.onTimeout(this.idx);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
