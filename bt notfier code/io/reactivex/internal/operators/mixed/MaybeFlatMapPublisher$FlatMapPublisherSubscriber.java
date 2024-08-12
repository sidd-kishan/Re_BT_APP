/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class MaybeFlatMapPublisher.FlatMapPublisherSubscriber<T, R>
extends AtomicReference<Subscription>
implements FlowableSubscriber<R>,
MaybeObserver<T>,
Subscription {
    private static final long serialVersionUID = -8948264376121066672L;
    final Subscriber<? super R> downstream;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final AtomicLong requested;
    Disposable upstream;

    MaybeFlatMapPublisher.FlatMapPublisherSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.downstream = subscriber;
        this.mapper = function;
        this.requested = new AtomicLong();
    }

    public void cancel() {
        this.upstream.dispose();
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(R r) {
        this.downstream.onNext(r);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce((AtomicReference)this, (AtomicLong)this.requested, (Subscription)subscription);
    }

    public void onSuccess(T object) {
        try {
            object = (Publisher)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null Publisher");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        object.subscribe((Subscriber)this);
    }

    public void request(long l) {
        SubscriptionHelper.deferredRequest((AtomicReference)this, (AtomicLong)this.requested, (long)l);
    }
}
