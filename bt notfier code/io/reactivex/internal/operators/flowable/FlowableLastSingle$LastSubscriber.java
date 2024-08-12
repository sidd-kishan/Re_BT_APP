/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

static final class FlowableLastSingle.LastSubscriber<T>
implements FlowableSubscriber<T>,
Disposable {
    final T defaultItem;
    final SingleObserver<? super T> downstream;
    T item;
    Subscription upstream;

    FlowableLastSingle.LastSubscriber(SingleObserver<? super T> singleObserver, T t) {
        this.downstream = singleObserver;
        this.defaultItem = t;
    }

    public void dispose() {
        this.upstream.cancel();
        this.upstream = SubscriptionHelper.CANCELLED;
    }

    public boolean isDisposed() {
        boolean bl = this.upstream == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        this.upstream = SubscriptionHelper.CANCELLED;
        T t = this.item;
        if (t != null) {
            this.item = null;
            this.downstream.onSuccess(t);
        } else {
            t = this.defaultItem;
            if (t != null) {
                this.downstream.onSuccess(t);
            } else {
                this.downstream.onError((Throwable)new NoSuchElementException());
            }
        }
    }

    public void onError(Throwable throwable) {
        this.upstream = SubscriptionHelper.CANCELLED;
        this.item = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.item = t;
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Disposable)this);
        subscription.request(Long.MAX_VALUE);
    }
}
