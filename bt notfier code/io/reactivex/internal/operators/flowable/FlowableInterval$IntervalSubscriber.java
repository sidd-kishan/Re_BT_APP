/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableInterval.IntervalSubscriber
extends AtomicLong
implements Subscription,
Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    long count;
    final Subscriber<? super Long> downstream;
    final AtomicReference<Disposable> resource = new AtomicReference();

    FlowableInterval.IntervalSubscriber(Subscriber<? super Long> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        DisposableHelper.dispose(this.resource);
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this, (long)l);
    }

    @Override
    public void run() {
        if (this.resource.get() == DisposableHelper.DISPOSED) return;
        if (this.get() != 0L) {
            Subscriber<? super Long> subscriber = this.downstream;
            long l = this.count;
            this.count = l + 1L;
            subscriber.onNext((Object)l);
            BackpressureHelper.produced((AtomicLong)this, (long)1L);
        } else {
            Subscriber<? super Long> subscriber = this.downstream;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can't deliver value ");
            stringBuilder.append(this.count);
            stringBuilder.append(" due to lack of requests");
            subscriber.onError((Throwable)new MissingBackpressureException(stringBuilder.toString()));
            DisposableHelper.dispose(this.resource);
        }
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.setOnce(this.resource, (Disposable)disposable);
    }
}
