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
import org.reactivestreams.Subscriber;

static final class FlowableOnErrorReturn.OnErrorReturnSubscriber<T>
extends SinglePostCompleteSubscriber<T, T> {
    private static final long serialVersionUID = -3740826063558713822L;
    final Function<? super Throwable, ? extends T> valueSupplier;

    FlowableOnErrorReturn.OnErrorReturnSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends T> function) {
        super(subscriber);
        this.valueSupplier = function;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        Object object;
        try {
            object = ObjectHelper.requireNonNull((Object)this.valueSupplier.apply((Object)throwable), (String)"The valueSupplier returned a null value");
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
            return;
        }
        this.complete(object);
    }

    public void onNext(T t) {
        ++this.produced;
        this.downstream.onNext(t);
    }
}
