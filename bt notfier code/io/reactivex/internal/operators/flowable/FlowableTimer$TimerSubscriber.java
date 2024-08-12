/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableTimer.TimerSubscriber
extends AtomicReference<Disposable>
implements Subscription,
Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    final Subscriber<? super Long> downstream;
    volatile boolean requested;

    FlowableTimer.TimerSubscriber(Subscriber<? super Long> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        this.requested = true;
    }

    @Override
    public void run() {
        if (this.get() == DisposableHelper.DISPOSED) return;
        if (this.requested) {
            this.downstream.onNext((Object)0L);
            this.lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
        } else {
            this.lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onError((Throwable)new MissingBackpressureException("Can't deliver value due to lack of requests"));
        }
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.trySet((AtomicReference)this, (Disposable)disposable);
    }
}
