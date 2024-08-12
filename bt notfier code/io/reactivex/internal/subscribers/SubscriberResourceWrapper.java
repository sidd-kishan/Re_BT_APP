/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberResourceWrapper<T>
extends AtomicReference<Disposable>
implements FlowableSubscriber<T>,
Disposable,
Subscription {
    private static final long serialVersionUID = -8612022020200669122L;
    final Subscriber<? super T> downstream;
    final AtomicReference<Subscription> upstream = new AtomicReference();

    public SubscriberResourceWrapper(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        this.dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.upstream.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        DisposableHelper.dispose((AtomicReference)this);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose((AtomicReference)this);
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce(this.upstream, (Subscription)subscription)) return;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        this.upstream.get().request(l);
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.set((AtomicReference)this, (Disposable)disposable);
    }
}
