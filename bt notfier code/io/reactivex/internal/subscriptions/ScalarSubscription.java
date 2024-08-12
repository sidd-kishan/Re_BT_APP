/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class ScalarSubscription<T>
extends AtomicInteger
implements QueueSubscription<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final Subscriber<? super T> subscriber;
    final T value;

    public ScalarSubscription(Subscriber<? super T> subscriber, T t) {
        this.subscriber = subscriber;
        this.value = t;
    }

    public void cancel() {
        this.lazySet(2);
    }

    public void clear() {
        this.lazySet(1);
    }

    public boolean isCancelled() {
        boolean bl = this.get() == 2;
        return bl;
    }

    public boolean isEmpty() {
        boolean bl = this.get() != 0;
        return bl;
    }

    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public T poll() {
        if (this.get() != 0) return null;
        this.lazySet(1);
        return this.value;
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) {
            return;
        }
        if (!this.compareAndSet(0, 1)) return;
        Subscriber<? super T> subscriber = this.subscriber;
        subscriber.onNext(this.value);
        if (this.get() == 2) return;
        subscriber.onComplete();
    }

    public int requestFusion(int n) {
        return n & 1;
    }
}
