/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.subscriptions.DeferredScalarSubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromFuture<T>
extends Flowable<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public FlowableFromFuture(Future<? extends T> future, long l, TimeUnit timeUnit) {
        this.future = future;
        this.timeout = l;
        this.unit = timeUnit;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        block3: {
            T t;
            DeferredScalarSubscription deferredScalarSubscription;
            block2: {
                deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
                subscriber.onSubscribe((Subscription)deferredScalarSubscription);
                try {
                    t = this.unit != null ? this.future.get(this.timeout, this.unit) : this.future.get();
                    if (t != null) break block2;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    if (deferredScalarSubscription.isCancelled()) return;
                    subscriber.onError(throwable);
                    return;
                }
                subscriber.onError((Throwable)new NullPointerException("The future returned null"));
                break block3;
            }
            deferredScalarSubscription.complete(t);
        }
    }
}
