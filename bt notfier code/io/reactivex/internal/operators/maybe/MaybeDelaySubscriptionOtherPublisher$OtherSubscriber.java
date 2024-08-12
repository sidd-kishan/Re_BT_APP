/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher$DelayMaybeObserver
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

static final class MaybeDelaySubscriptionOtherPublisher.OtherSubscriber<T>
implements FlowableSubscriber<Object>,
Disposable {
    final MaybeDelaySubscriptionOtherPublisher.DelayMaybeObserver<T> main;
    MaybeSource<T> source;
    Subscription upstream;

    MaybeDelaySubscriptionOtherPublisher.OtherSubscriber(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
        this.main = new MaybeDelaySubscriptionOtherPublisher.DelayMaybeObserver(maybeObserver);
        this.source = maybeSource;
    }

    public void dispose() {
        this.upstream.cancel();
        this.upstream = SubscriptionHelper.CANCELLED;
        DisposableHelper.dispose(this.main);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.main.get()));
    }

    public void onComplete() {
        if (this.upstream == SubscriptionHelper.CANCELLED) return;
        this.upstream = SubscriptionHelper.CANCELLED;
        this.subscribeNext();
    }

    public void onError(Throwable throwable) {
        if (this.upstream != SubscriptionHelper.CANCELLED) {
            this.upstream = SubscriptionHelper.CANCELLED;
            this.main.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(Object object) {
        if (this.upstream == SubscriptionHelper.CANCELLED) return;
        this.upstream.cancel();
        this.upstream = SubscriptionHelper.CANCELLED;
        this.subscribeNext();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.main.downstream.onSubscribe((Disposable)this);
        subscription.request(Long.MAX_VALUE);
    }

    void subscribeNext() {
        MaybeSource<T> maybeSource = this.source;
        this.source = null;
        maybeSource.subscribe(this.main);
    }
}
