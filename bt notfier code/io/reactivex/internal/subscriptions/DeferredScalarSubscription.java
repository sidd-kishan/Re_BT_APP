/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.subscriptions;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;

public class DeferredScalarSubscription<T>
extends BasicIntQueueSubscription<T> {
    static final int CANCELLED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2151279923272604993L;
    protected final Subscriber<? super T> downstream;
    protected T value;

    public DeferredScalarSubscription(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        this.set(4);
        this.value = null;
    }

    public final void clear() {
        this.lazySet(32);
        this.value = null;
    }

    public final void complete(T t) {
        int n;
        int n2 = this.get();
        do {
            if (n2 == 8) {
                this.value = t;
                this.lazySet(16);
                Subscriber<? super T> subscriber = this.downstream;
                subscriber.onNext(t);
                if (this.get() == 4) return;
                subscriber.onComplete();
                return;
            }
            if ((n2 & 0xFFFFFFFD) != 0) {
                return;
            }
            if (n2 == 2) {
                this.lazySet(3);
                Subscriber<? super T> subscriber = this.downstream;
                subscriber.onNext(t);
                if (this.get() == 4) return;
                subscriber.onComplete();
                return;
            }
            this.value = t;
            if (this.compareAndSet(0, 1)) {
                return;
            }
            n2 = n = this.get();
        } while (n != 4);
        this.value = null;
    }

    public final boolean isCancelled() {
        boolean bl = this.get() == 4;
        return bl;
    }

    public final boolean isEmpty() {
        boolean bl = this.get() != 16;
        return bl;
    }

    public final T poll() {
        if (this.get() != 16) return null;
        this.lazySet(32);
        T t = this.value;
        this.value = null;
        return t;
    }

    public final void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        do {
            int n;
            if (((n = this.get()) & 0xFFFFFFFE) != 0) {
                return;
            }
            if (n != 1) continue;
            if (!this.compareAndSet(1, 3)) return;
            T t = this.value;
            if (t == null) return;
            this.value = null;
            Subscriber<? super T> subscriber = this.downstream;
            subscriber.onNext(t);
            if (this.get() == 4) return;
            subscriber.onComplete();
            return;
        } while (!this.compareAndSet(0, 2));
    }

    public final int requestFusion(int n) {
        if ((n & 2) == 0) return 0;
        this.lazySet(8);
        return 2;
    }

    public final boolean tryCancel() {
        boolean bl = this.getAndSet(4) != 4;
        return bl;
    }
}
