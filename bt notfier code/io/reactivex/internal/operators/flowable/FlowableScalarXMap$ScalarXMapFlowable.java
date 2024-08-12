/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.internal.subscriptions.ScalarSubscription
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableScalarXMap.ScalarXMapFlowable<T, R>
extends Flowable<R> {
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final T value;

    FlowableScalarXMap.ScalarXMapFlowable(T t, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.value = t;
        this.mapper = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        Object object;
        try {
            object = (Publisher)ObjectHelper.requireNonNull((Object)this.mapper.apply(this.value), (String)"The mapper returned a null Publisher");
        }
        catch (Throwable throwable) {
            EmptySubscription.error((Throwable)throwable, subscriber);
            return;
        }
        if (object instanceof Callable) {
            block6: {
                try {
                    object = ((Callable)object).call();
                    if (object != null) break block6;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptySubscription.error((Throwable)throwable, subscriber);
                    return;
                }
                EmptySubscription.complete(subscriber);
                return;
            }
            subscriber.onSubscribe((Subscription)new ScalarSubscription(subscriber, object));
        } else {
            object.subscribe(subscriber);
        }
    }
}
