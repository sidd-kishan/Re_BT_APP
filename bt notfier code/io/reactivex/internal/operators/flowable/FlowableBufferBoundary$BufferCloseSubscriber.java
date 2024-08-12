/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferBoundarySubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowableBufferBoundary.BufferCloseSubscriber<T, C extends Collection<? super T>>
extends AtomicReference<Subscription>
implements FlowableSubscriber<Object>,
Disposable {
    private static final long serialVersionUID = -8498650778633225126L;
    final long index;
    final FlowableBufferBoundary.BufferBoundarySubscriber<T, C, ?, ?> parent;

    FlowableBufferBoundary.BufferCloseSubscriber(FlowableBufferBoundary.BufferBoundarySubscriber<T, C, ?, ?> bufferBoundarySubscriber, long l) {
        this.parent = bufferBoundarySubscriber;
        this.index = l;
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
        this.parent.close(this, this.index);
    }

    public void onError(Throwable throwable) {
        if (this.get() != SubscriptionHelper.CANCELLED) {
            this.lazySet(SubscriptionHelper.CANCELLED);
            this.parent.boundaryError((Disposable)this, throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(Object object) {
        object = (Subscription)this.get();
        if (object == SubscriptionHelper.CANCELLED) return;
        this.lazySet(SubscriptionHelper.CANCELLED);
        object.cancel();
        this.parent.close(this, this.index);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
