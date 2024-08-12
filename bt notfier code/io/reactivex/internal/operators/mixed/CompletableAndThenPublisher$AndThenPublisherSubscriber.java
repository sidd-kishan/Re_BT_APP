/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class CompletableAndThenPublisher.AndThenPublisherSubscriber<R>
extends AtomicReference<Subscription>
implements FlowableSubscriber<R>,
CompletableObserver,
Subscription {
    private static final long serialVersionUID = -8948264376121066672L;
    final Subscriber<? super R> downstream;
    Publisher<? extends R> other;
    final AtomicLong requested;
    Disposable upstream;

    CompletableAndThenPublisher.AndThenPublisherSubscriber(Subscriber<? super R> subscriber, Publisher<? extends R> publisher) {
        this.downstream = subscriber;
        this.other = publisher;
        this.requested = new AtomicLong();
    }

    public void cancel() {
        this.upstream.dispose();
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public void onComplete() {
        Publisher<? extends R> publisher = this.other;
        if (publisher == null) {
            this.downstream.onComplete();
        } else {
            this.other = null;
            publisher.subscribe((Subscriber)this);
        }
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

    public void request(long l) {
        SubscriptionHelper.deferredRequest((AtomicReference)this, (AtomicLong)this.requested, (long)l);
    }
}
