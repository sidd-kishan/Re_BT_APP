/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableConcatWithCompletable.ConcatWithSubscriber<T>
extends AtomicReference<Disposable>
implements FlowableSubscriber<T>,
CompletableObserver,
Subscription {
    private static final long serialVersionUID = -7346385463600070225L;
    final Subscriber<? super T> downstream;
    boolean inCompletable;
    CompletableSource other;
    Subscription upstream;

    FlowableConcatWithCompletable.ConcatWithSubscriber(Subscriber<? super T> subscriber, CompletableSource completableSource) {
        this.downstream = subscriber;
        this.other = completableSource;
    }

    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onComplete() {
        if (this.inCompletable) {
            this.downstream.onComplete();
        } else {
            this.inCompletable = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            CompletableSource completableSource = this.other;
            this.other = null;
            completableSource.subscribe((CompletableObserver)this);
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        this.upstream.request(l);
    }
}
