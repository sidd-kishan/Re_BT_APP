/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.subscriptions.DeferredScalarSubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class MaybeToFlowable.MaybeToFlowableSubscriber<T>
extends DeferredScalarSubscription<T>
implements MaybeObserver<T> {
    private static final long serialVersionUID = 7603343402964826922L;
    Disposable upstream;

    MaybeToFlowable.MaybeToFlowableSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    public void cancel() {
        super.cancel();
        this.upstream.dispose();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void onSuccess(T t) {
        this.complete(t);
    }
}
