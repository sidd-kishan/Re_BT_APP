/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.NotificationLite
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class BlockingSubscriber<T>
extends AtomicReference<Subscription>
implements FlowableSubscriber<T>,
Subscription {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public BlockingSubscriber(Queue<Object> queue) {
        this.queue = queue;
    }

    public void cancel() {
        if (!SubscriptionHelper.cancel((AtomicReference)this)) return;
        this.queue.offer(TERMINATED);
    }

    public boolean isCancelled() {
        boolean bl = this.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    public void onError(Throwable throwable) {
        this.queue.offer(NotificationLite.error((Throwable)throwable));
    }

    public void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription)) return;
        this.queue.offer(NotificationLite.subscription((Subscription)this));
    }

    public void request(long l) {
        ((Subscription)this.get()).request(l);
    }
}
