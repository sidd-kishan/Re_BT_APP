/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.QueueDrainHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class InnerQueuedSubscriber<T>
extends AtomicReference<Subscription>
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final InnerQueuedSubscriberSupport<T> parent;
    final int prefetch;
    long produced;
    volatile SimpleQueue<T> queue;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> innerQueuedSubscriberSupport, int n) {
        this.parent = innerQueuedSubscriberSupport;
        this.prefetch = n;
        this.limit = n - (n >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public boolean isDone() {
        return this.done;
    }

    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(this, throwable);
    }

    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription)) return;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(3);
            if (n == 1) {
                this.fusionMode = n;
                this.queue = queueSubscription;
                this.done = true;
                this.parent.innerComplete(this);
                return;
            }
            if (n == 2) {
                this.fusionMode = n;
                this.queue = queueSubscription;
                QueueDrainHelper.request((Subscription)subscription, (int)this.prefetch);
                return;
            }
        }
        this.queue = QueueDrainHelper.createQueue((int)this.prefetch);
        QueueDrainHelper.request((Subscription)subscription, (int)this.prefetch);
    }

    public SimpleQueue<T> queue() {
        return this.queue;
    }

    public void request(long l) {
        if (this.fusionMode == 1) return;
        if ((l = this.produced + l) >= (long)this.limit) {
            this.produced = 0L;
            ((Subscription)this.get()).request(l);
        } else {
            this.produced = l;
        }
    }

    public void requestOne() {
        if (this.fusionMode == 1) return;
        long l = this.produced + 1L;
        if (l == (long)this.limit) {
            this.produced = 0L;
            ((Subscription)this.get()).request(l);
        } else {
            this.produced = l;
        }
    }

    public void setDone() {
        this.done = true;
    }
}
