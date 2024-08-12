/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

static final class FlowableAllSingle.AllSubscriber<T>
implements FlowableSubscriber<T>,
Disposable {
    boolean done;
    final SingleObserver<? super Boolean> downstream;
    final Predicate<? super T> predicate;
    Subscription upstream;

    FlowableAllSingle.AllSubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
        this.downstream = singleObserver;
        this.predicate = predicate;
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
        this.downstream.onSuccess((Object)true);
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
        try {
            boolean bl = this.predicate.test(t);
            if (bl) return;
            this.done = true;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
            this.onError(throwable);
            return;
        }
        this.upstream.cancel();
        this.upstream = SubscriptionHelper.CANCELLED;
        this.downstream.onSuccess((Object)false);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Disposable)this);
        subscription.request(Long.MAX_VALUE);
    }
}
