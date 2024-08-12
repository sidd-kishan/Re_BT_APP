/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

static final class FlowableConcatWithMaybe.ConcatWithSubscriber<T>
extends SinglePostCompleteSubscriber<T, T>
implements MaybeObserver<T> {
    private static final long serialVersionUID = -7346385463600070225L;
    boolean inMaybe;
    MaybeSource<? extends T> other;
    final AtomicReference<Disposable> otherDisposable;

    FlowableConcatWithMaybe.ConcatWithSubscriber(Subscriber<? super T> subscriber, MaybeSource<? extends T> maybeSource) {
        super(subscriber);
        this.other = maybeSource;
        this.otherDisposable = new AtomicReference();
    }

    public void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.otherDisposable);
    }

    public void onComplete() {
        if (this.inMaybe) {
            this.downstream.onComplete();
        } else {
            this.inMaybe = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            MaybeSource<? extends T> maybeSource = this.other;
            this.other = null;
            maybeSource.subscribe((MaybeObserver)this);
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        ++this.produced;
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.otherDisposable, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        this.complete(t);
    }
}
