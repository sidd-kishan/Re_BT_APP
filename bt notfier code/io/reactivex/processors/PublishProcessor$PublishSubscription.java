/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.PublishProcessor
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.processors;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.PublishProcessor;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class PublishProcessor.PublishSubscription<T>
extends AtomicLong
implements Subscription {
    private static final long serialVersionUID = 3562861878281475070L;
    final Subscriber<? super T> downstream;
    final PublishProcessor<T> parent;

    PublishProcessor.PublishSubscription(Subscriber<? super T> subscriber, PublishProcessor<T> publishProcessor) {
        this.downstream = subscriber;
        this.parent = publishProcessor;
    }

    public void cancel() {
        if (this.getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) return;
        this.parent.remove(this);
    }

    public boolean isCancelled() {
        boolean bl = this.get() == Long.MIN_VALUE;
        return bl;
    }

    boolean isFull() {
        boolean bl = this.get() == 0L;
        return bl;
    }

    public void onComplete() {
        if (this.get() == Long.MIN_VALUE) return;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.get() != Long.MIN_VALUE) {
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        long l = this.get();
        if (l == Long.MIN_VALUE) {
            return;
        }
        if (l != 0L) {
            this.downstream.onNext(t);
            BackpressureHelper.producedCancel((AtomicLong)this, (long)1L);
        } else {
            this.cancel();
            this.downstream.onError((Throwable)new MissingBackpressureException("Could not emit value due to lack of requests"));
        }
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.addCancel((AtomicLong)this, (long)l);
    }
}
