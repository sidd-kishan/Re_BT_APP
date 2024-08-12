/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.flowable.FlowableFlatMap$MergeSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowableFlatMap.InnerSubscriber<T, U>
extends AtomicReference<Subscription>
implements FlowableSubscriber<U>,
Disposable {
    private static final long serialVersionUID = -4606175640614850599L;
    final int bufferSize;
    volatile boolean done;
    int fusionMode;
    final long id;
    final int limit;
    final FlowableFlatMap.MergeSubscriber<T, U> parent;
    long produced;
    volatile SimpleQueue<U> queue;

    FlowableFlatMap.InnerSubscriber(FlowableFlatMap.MergeSubscriber<T, U> mergeSubscriber, long l) {
        int n;
        this.id = l;
        this.parent = mergeSubscriber;
        this.bufferSize = n = mergeSubscriber.bufferSize;
        this.limit = n >> 2;
    }

    public void dispose() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable throwable) {
        this.lazySet(SubscriptionHelper.CANCELLED);
        this.parent.innerError(this, throwable);
    }

    public void onNext(U u) {
        if (this.fusionMode != 2) {
            this.parent.tryEmit(u, this);
        } else {
            this.parent.drain();
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription)) return;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(7);
            if (n == 1) {
                this.fusionMode = n;
                this.queue = queueSubscription;
                this.done = true;
                this.parent.drain();
                return;
            }
            if (n == 2) {
                this.fusionMode = n;
                this.queue = queueSubscription;
            }
        }
        subscription.request((long)this.bufferSize);
    }

    void requestMore(long l) {
        if (this.fusionMode == 1) return;
        if ((l = this.produced + l) >= (long)this.limit) {
            this.produced = 0L;
            ((Subscription)this.get()).request(l);
        } else {
            this.produced = l;
        }
    }
}
