/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

static final class FlowableSingleSingle.SingleElementSubscriber<T>
implements FlowableSubscriber<T>,
Disposable {
    final T defaultValue;
    boolean done;
    final SingleObserver<? super T> downstream;
    Subscription upstream;
    T value;

    FlowableSingleSingle.SingleElementSubscriber(SingleObserver<? super T> singleObserver, T t) {
        this.downstream = singleObserver;
        this.defaultValue = t;
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
        if (this.done) {
            return;
        }
        this.done = true;
        this.upstream = SubscriptionHelper.CANCELLED;
        T t = this.value;
        this.value = null;
        T t2 = t;
        if (t == null) {
            t2 = this.defaultValue;
        }
        if (t2 != null) {
            this.downstream.onSuccess(t2);
        } else {
            this.downstream.onError((Throwable)new NoSuchElementException());
        }
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.upstream = SubscriptionHelper.CANCELLED;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.value != null) {
            this.done = true;
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onError((Throwable)new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
        this.value = t;
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Disposable)this);
        subscription.request(Long.MAX_VALUE);
    }
}
