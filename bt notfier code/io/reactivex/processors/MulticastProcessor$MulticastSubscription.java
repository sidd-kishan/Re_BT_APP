/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.processors.MulticastProcessor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.processors;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.MulticastProcessor;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class MulticastProcessor.MulticastSubscription<T>
extends AtomicLong
implements Subscription {
    private static final long serialVersionUID = -363282618957264509L;
    final Subscriber<? super T> downstream;
    long emitted;
    final MulticastProcessor<T> parent;

    MulticastProcessor.MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
        this.downstream = subscriber;
        this.parent = multicastProcessor;
    }

    public void cancel() {
        if (this.getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) return;
        this.parent.remove(this);
    }

    void onComplete() {
        if (this.get() == Long.MIN_VALUE) return;
        this.downstream.onComplete();
    }

    void onError(Throwable throwable) {
        if (this.get() == Long.MIN_VALUE) return;
        this.downstream.onError(throwable);
    }

    void onNext(T t) {
        if (this.get() == Long.MIN_VALUE) return;
        ++this.emitted;
        this.downstream.onNext(t);
    }

    public void request(long l) {
        long l2;
        long l3;
        if (!SubscriptionHelper.validate((long)l)) return;
        do {
            if ((l3 = this.get()) == Long.MIN_VALUE) return;
            l2 = Long.MAX_VALUE;
            if (l3 == Long.MAX_VALUE) return;
            long l4 = l3 + l;
            if (l4 < 0L) continue;
            l2 = l4;
        } while (!this.compareAndSet(l3, l2));
        this.parent.drain();
    }
}
