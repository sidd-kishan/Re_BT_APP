/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableScalarXMap$ScalarXMapFlowable
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.internal.subscriptions.ScalarSubscription
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScalarXMap {
    private FlowableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Flowable<U> scalarXMap(T t, Function<? super T, ? extends Publisher<? extends U>> function) {
        return RxJavaPlugins.onAssembly((Flowable)new ScalarXMapFlowable(t, function));
    }

    public static <T, R> boolean tryScalarXMapSubscribe(Publisher<T> object, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        block8: {
            if (!(object instanceof Callable)) return false;
            try {
                object = ((Callable)object).call();
                if (object != null) break block8;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptySubscription.error((Throwable)throwable, subscriber);
                return true;
            }
            EmptySubscription.complete(subscriber);
            return true;
        }
        try {
            object = (Publisher)ObjectHelper.requireNonNull((Object)function.apply(object), (String)"The mapper returned a null Publisher");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptySubscription.error((Throwable)throwable, subscriber);
            return true;
        }
        if (object instanceof Callable) {
            block9: {
                try {
                    object = ((Callable)object).call();
                    if (object != null) break block9;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    EmptySubscription.error((Throwable)throwable, subscriber);
                    return true;
                }
                EmptySubscription.complete(subscriber);
                return true;
            }
            subscriber.onSubscribe((Subscription)new ScalarSubscription(subscriber, object));
        } else {
            object.subscribe(subscriber);
        }
        return true;
    }
}
