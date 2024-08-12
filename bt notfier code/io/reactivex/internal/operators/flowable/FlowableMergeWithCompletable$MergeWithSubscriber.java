/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.HalfSerializer
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableMergeWithCompletable.MergeWithSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = -4592979584110982903L;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error;
    volatile boolean mainDone;
    final AtomicReference<Subscription> mainSubscription;
    volatile boolean otherDone;
    final OtherObserver otherObserver;
    final AtomicLong requested;

    FlowableMergeWithCompletable.MergeWithSubscriber(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
        this.mainSubscription = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.mainSubscription);
        DisposableHelper.dispose((AtomicReference)this.otherObserver);
    }

    public void onComplete() {
        this.mainDone = true;
        if (!this.otherDone) return;
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel(this.mainSubscription);
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onNext(T t) {
        HalfSerializer.onNext(this.downstream, t, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.mainSubscription, (AtomicLong)this.requested, (Subscription)subscription);
    }

    void otherComplete() {
        this.otherDone = true;
        if (!this.mainDone) return;
        HalfSerializer.onComplete(this.downstream, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    void otherError(Throwable throwable) {
        SubscriptionHelper.cancel(this.mainSubscription);
        HalfSerializer.onError(this.downstream, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void request(long l) {
        SubscriptionHelper.deferredRequest(this.mainSubscription, (AtomicLong)this.requested, (long)l);
    }
}
