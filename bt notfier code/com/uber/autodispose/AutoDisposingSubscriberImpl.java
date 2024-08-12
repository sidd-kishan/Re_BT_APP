/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AtomicThrowable
 *  com.uber.autodispose.AutoDisposableHelper
 *  com.uber.autodispose.AutoDisposeEndConsumerHelper
 *  com.uber.autodispose.AutoDisposingSubscriberImpl$1
 *  com.uber.autodispose.AutoSubscriptionHelper
 *  com.uber.autodispose.HalfSerializer
 *  com.uber.autodispose.observers.AutoDisposingSubscriber
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.Disposable
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package com.uber.autodispose;

import com.uber.autodispose.AtomicThrowable;
import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposeEndConsumerHelper;
import com.uber.autodispose.AutoDisposingSubscriberImpl;
import com.uber.autodispose.AutoSubscriptionHelper;
import com.uber.autodispose.HalfSerializer;
import com.uber.autodispose.observers.AutoDisposingSubscriber;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

final class AutoDisposingSubscriberImpl<T>
extends AtomicInteger
implements AutoDisposingSubscriber<T> {
    private final Subscriber<? super T> delegate;
    private final AtomicThrowable error;
    final AtomicReference<Subscription> mainSubscription = new AtomicReference();
    private final AtomicReference<Subscription> ref;
    private final AtomicLong requested;
    private final CompletableSource scope;
    final AtomicReference<Disposable> scopeDisposable = new AtomicReference();

    AutoDisposingSubscriberImpl(CompletableSource completableSource, Subscriber<? super T> subscriber) {
        this.error = new AtomicThrowable();
        this.ref = new AtomicReference();
        this.requested = new AtomicLong();
        this.scope = completableSource;
        this.delegate = subscriber;
    }

    public void cancel() {
        AutoDisposableHelper.dispose(this.scopeDisposable);
        AutoSubscriptionHelper.cancel(this.mainSubscription);
    }

    public Subscriber<? super T> delegateSubscriber() {
        return this.delegate;
    }

    public void dispose() {
        this.cancel();
    }

    public boolean isDisposed() {
        boolean bl = this.mainSubscription.get() == AutoSubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        if (this.isDisposed()) return;
        this.mainSubscription.lazySet((Subscription)AutoSubscriptionHelper.CANCELLED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        HalfSerializer.onComplete(this.delegate, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onError(Throwable throwable) {
        if (this.isDisposed()) return;
        this.mainSubscription.lazySet((Subscription)AutoSubscriptionHelper.CANCELLED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        HalfSerializer.onError(this.delegate, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onNext(T t) {
        if (this.isDisposed()) return;
        if (!HalfSerializer.onNext(this.delegate, t, (AtomicInteger)this, (AtomicThrowable)this.error)) return;
        this.mainSubscription.lazySet((Subscription)AutoSubscriptionHelper.CANCELLED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
    }

    public void onSubscribe(Subscription subscription) {
        1 var2_2 = new /* Unavailable Anonymous Inner Class!! */;
        if (!AutoDisposeEndConsumerHelper.setOnce(this.scopeDisposable, (Disposable)var2_2, this.getClass())) return;
        this.delegate.onSubscribe((Subscription)this);
        this.scope.subscribe((CompletableObserver)var2_2);
        if (!AutoDisposeEndConsumerHelper.setOnce(this.mainSubscription, (Subscription)subscription, this.getClass())) return;
        AutoSubscriptionHelper.deferredSetOnce(this.ref, (AtomicLong)this.requested, (Subscription)subscription);
    }

    public void request(long l) {
        AutoSubscriptionHelper.deferredRequest(this.ref, (AtomicLong)this.requested, (long)l);
    }
}
