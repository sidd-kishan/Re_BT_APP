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
import java.util.Collection;
import org.reactivestreams.Subscription;

static final class FlowableToListSingle.ToListSubscriber<T, U extends Collection<? super T>>
implements FlowableSubscriber<T>,
Disposable {
    final SingleObserver<? super U> downstream;
    Subscription upstream;
    U value;

    FlowableToListSingle.ToListSubscriber(SingleObserver<? super U> singleObserver, U u) {
        this.downstream = singleObserver;
        this.value = u;
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
        this.downstream.onSuccess(this.value);
    }

    public void onError(Throwable throwable) {
        this.value = null;
        this.upstream = SubscriptionHelper.CANCELLED;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.value.add(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Disposable)this);
        subscription.request(Long.MAX_VALUE);
    }
}
