/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberCompletableObserver<T>
implements CompletableObserver,
Subscription {
    final Subscriber<? super T> subscriber;
    Disposable upstream;

    public SubscriberCompletableObserver(Subscriber<? super T> subscriber) {
        this.subscriber = subscriber;
    }

    public void cancel() {
        this.upstream.dispose();
    }

    public void onComplete() {
        this.subscriber.onComplete();
    }

    public void onError(Throwable throwable) {
        this.subscriber.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.subscriber.onSubscribe((Subscription)this);
    }

    public void request(long l) {
    }
}
