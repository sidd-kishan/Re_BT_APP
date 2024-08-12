/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

static final class FlowableConcatWithSingle.ConcatWithSubscriber<T>
extends SinglePostCompleteSubscriber<T, T>
implements SingleObserver<T> {
    private static final long serialVersionUID = -7346385463600070225L;
    SingleSource<? extends T> other;
    final AtomicReference<Disposable> otherDisposable;

    FlowableConcatWithSingle.ConcatWithSubscriber(Subscriber<? super T> subscriber, SingleSource<? extends T> singleSource) {
        super(subscriber);
        this.other = singleSource;
        this.otherDisposable = new AtomicReference();
    }

    public void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.otherDisposable);
    }

    public void onComplete() {
        this.upstream = SubscriptionHelper.CANCELLED;
        SingleSource<? extends T> singleSource = this.other;
        this.other = null;
        singleSource.subscribe((SingleObserver)this);
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
