/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.subscriptions.DeferredScalarSubscription
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class SingleToFlowable.SingleToFlowableObserver<T>
extends DeferredScalarSubscription<T>
implements SingleObserver<T> {
    private static final long serialVersionUID = 187782011903685568L;
    Disposable upstream;

    SingleToFlowable.SingleToFlowableObserver(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    public void cancel() {
        super.cancel();
        this.upstream.dispose();
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
