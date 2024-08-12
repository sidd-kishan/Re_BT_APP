/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

static final class FlowableMapNotification.MapNotificationSubscriber<T, R>
extends SinglePostCompleteSubscriber<T, R> {
    private static final long serialVersionUID = 2757120512858778108L;
    final Callable<? extends R> onCompleteSupplier;
    final Function<? super Throwable, ? extends R> onErrorMapper;
    final Function<? super T, ? extends R> onNextMapper;

    FlowableMapNotification.MapNotificationSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Callable<? extends R> callable) {
        super(subscriber);
        this.onNextMapper = function;
        this.onErrorMapper = function2;
        this.onCompleteSupplier = callable;
    }

    public void onComplete() {
        Object object;
        try {
            object = ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), (String)"The onComplete publisher returned is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        this.complete(object);
    }

    public void onError(Throwable throwable) {
        Object object;
        try {
            object = ObjectHelper.requireNonNull((Object)this.onErrorMapper.apply((Object)throwable), (String)"The onError publisher returned is null");
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
            return;
        }
        this.complete(object);
    }

    public void onNext(T object) {
        try {
            object = ObjectHelper.requireNonNull((Object)this.onNextMapper.apply(object), (String)"The onNext publisher returned is null");
            ++this.produced;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        this.downstream.onNext(object);
    }
}
