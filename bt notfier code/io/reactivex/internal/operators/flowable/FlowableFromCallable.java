/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.DeferredScalarSubscription
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromCallable<T>
extends Flowable<T>
implements Callable<T> {
    final Callable<? extends T> callable;

    public FlowableFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }

    @Override
    public T call() throws Exception {
        return (T)ObjectHelper.requireNonNull(this.callable.call(), (String)"The callable returned a null value");
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Object object;
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe((Subscription)deferredScalarSubscription);
        try {
            object = ObjectHelper.requireNonNull(this.callable.call(), (String)"The callable returned a null value");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            if (deferredScalarSubscription.isCancelled()) {
                RxJavaPlugins.onError((Throwable)throwable);
            } else {
                subscriber.onError(throwable);
            }
            return;
        }
        deferredScalarSubscription.complete(object);
    }
}
