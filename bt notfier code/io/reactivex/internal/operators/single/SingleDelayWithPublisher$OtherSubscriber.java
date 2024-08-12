/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.observers.ResumeSingleObserver
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class SingleDelayWithPublisher.OtherSubscriber<T, U>
extends AtomicReference<Disposable>
implements FlowableSubscriber<U>,
Disposable {
    private static final long serialVersionUID = -8565274649390031272L;
    boolean done;
    final SingleObserver<? super T> downstream;
    final SingleSource<T> source;
    Subscription upstream;

    SingleDelayWithPublisher.OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
        this.downstream = singleObserver;
        this.source = singleSource;
    }

    public void dispose() {
        this.upstream.cancel();
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.source.subscribe((SingleObserver)new ResumeSingleObserver((AtomicReference)this, this.downstream));
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(U u) {
        this.upstream.cancel();
        this.onComplete();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Disposable)this);
        subscription.request(Long.MAX_VALUE);
    }
}
