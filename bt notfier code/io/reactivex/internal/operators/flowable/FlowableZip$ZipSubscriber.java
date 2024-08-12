/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.flowable.FlowableZip$ZipCoordinator
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowableZip.ZipSubscriber<T, R>
extends AtomicReference<Subscription>
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -4627193790118206028L;
    volatile boolean done;
    final int limit;
    final FlowableZip.ZipCoordinator<T, R> parent;
    final int prefetch;
    long produced;
    SimpleQueue<T> queue;
    int sourceMode;

    FlowableZip.ZipSubscriber(FlowableZip.ZipCoordinator<T, R> zipCoordinator, int n) {
        this.parent = zipCoordinator;
        this.prefetch = n;
        this.limit = n - (n >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable throwable) {
        this.parent.error(this, throwable);
    }

    public void onNext(T t) {
        if (this.sourceMode != 2) {
            this.queue.offer(t);
        }
        this.parent.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription)) return;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(7);
            if (n == 1) {
                this.sourceMode = n;
                this.queue = queueSubscription;
                this.done = true;
                this.parent.drain();
                return;
            }
            if (n == 2) {
                this.sourceMode = n;
                this.queue = queueSubscription;
                subscription.request((long)this.prefetch);
                return;
            }
        }
        this.queue = new SpscArrayQueue(this.prefetch);
        subscription.request((long)this.prefetch);
    }

    public void request(long l) {
        if (this.sourceMode == 1) return;
        if ((l = this.produced + l) >= (long)this.limit) {
            this.produced = 0L;
            ((Subscription)this.get()).request(l);
        } else {
            this.produced = l;
        }
    }
}
