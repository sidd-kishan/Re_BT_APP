/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class SingleFlatMapPublisher.SingleFlatMapPublisherObserver<S, T>
extends AtomicLong
implements SingleObserver<S>,
FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = 7759721921468635667L;
    Disposable disposable;
    final Subscriber<? super T> downstream;
    final Function<? super S, ? extends Publisher<? extends T>> mapper;
    final AtomicReference<Subscription> parent;

    SingleFlatMapPublisher.SingleFlatMapPublisherObserver(Subscriber<? super T> subscriber, Function<? super S, ? extends Publisher<? extends T>> function) {
        this.downstream = subscriber;
        this.mapper = function;
        this.parent = new AtomicReference();
    }

    public void cancel() {
        this.disposable.dispose();
        SubscriptionHelper.cancel(this.parent);
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        this.disposable = disposable;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.parent, (AtomicLong)this, (Subscription)subscription);
    }

    public void onSuccess(S object) {
        try {
            object = (Publisher)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"the mapper returned a null Publisher");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        object.subscribe((Subscriber)this);
    }

    public void request(long l) {
        SubscriptionHelper.deferredRequest(this.parent, (AtomicLong)this, (long)l);
    }
}
