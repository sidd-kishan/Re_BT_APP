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
package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

static final class SingleFromPublisher.ToSingleObserver<T>
implements FlowableSubscriber<T>,
Disposable {
    volatile boolean disposed;
    boolean done;
    final SingleObserver<? super T> downstream;
    Subscription upstream;
    T value;

    SingleFromPublisher.ToSingleObserver(SingleObserver<? super T> singleObserver) {
        this.downstream = singleObserver;
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.cancel();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        T t = this.value;
        this.value = null;
        if (t == null) {
            this.downstream.onError((Throwable)new NoSuchElementException("The source Publisher is empty"));
        } else {
            this.downstream.onSuccess(t);
        }
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.value = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.value != null) {
            this.upstream.cancel();
            this.done = true;
            this.value = null;
            this.downstream.onError((Throwable)new IndexOutOfBoundsException("Too many elements in the Publisher"));
        } else {
            this.value = t;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Disposable)this);
        subscription.request(Long.MAX_VALUE);
    }
}
