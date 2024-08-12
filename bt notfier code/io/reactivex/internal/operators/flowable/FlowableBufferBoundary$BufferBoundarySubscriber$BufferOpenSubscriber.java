/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferBoundarySubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowableBufferBoundary.BufferBoundarySubscriber.BufferOpenSubscriber<Open>
extends AtomicReference<Subscription>
implements FlowableSubscriber<Open>,
Disposable {
    private static final long serialVersionUID = -8498650778633225126L;
    final FlowableBufferBoundary.BufferBoundarySubscriber<?, ?, Open, ?> parent;

    FlowableBufferBoundary.BufferBoundarySubscriber.BufferOpenSubscriber(FlowableBufferBoundary.BufferBoundarySubscriber<?, ?, Open, ?> bufferBoundarySubscriber) {
        this.parent = bufferBoundarySubscriber;
    }

    public void dispose() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        this.lazySet(SubscriptionHelper.CANCELLED);
        this.parent.openComplete(this);
    }

    public void onError(Throwable throwable) {
        this.lazySet(SubscriptionHelper.CANCELLED);
        this.parent.boundaryError((Disposable)this, throwable);
    }

    public void onNext(Open Open) {
        this.parent.open(Open);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
