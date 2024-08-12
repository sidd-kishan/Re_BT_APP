/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualCoordinatorHelper
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowableSequenceEqual.EqualSubscriber<T>
extends AtomicReference<Subscription>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 4804128302091633067L;
    volatile boolean done;
    final int limit;
    final FlowableSequenceEqual.EqualCoordinatorHelper parent;
    final int prefetch;
    long produced;
    volatile SimpleQueue<T> queue;
    int sourceMode;

    FlowableSequenceEqual.EqualSubscriber(FlowableSequenceEqual.EqualCoordinatorHelper equalCoordinatorHelper, int n) {
        this.parent = equalCoordinatorHelper;
        this.limit = n - (n >> 2);
        this.prefetch = n;
    }

    public void cancel() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    void clear() {
        SimpleQueue<T> simpleQueue = this.queue;
        if (simpleQueue == null) return;
        simpleQueue.clear();
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(throwable);
    }

    public void onNext(T t) {
        if (this.sourceMode == 0 && !this.queue.offer(t)) {
            this.onError((Throwable)new MissingBackpressureException());
            return;
        }
        this.parent.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription)) return;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(3);
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

    public void request() {
        if (this.sourceMode == 1) return;
        long l = this.produced + 1L;
        if (l >= (long)this.limit) {
            this.produced = 0L;
            ((Subscription)this.get()).request(l);
        } else {
            this.produced = l;
        }
    }
}
