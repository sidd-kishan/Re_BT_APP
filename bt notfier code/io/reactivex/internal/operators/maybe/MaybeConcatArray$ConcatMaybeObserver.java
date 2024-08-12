/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BackpressureHelper
 *  io.reactivex.internal.util.NotificationLite
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class MaybeConcatArray.ConcatMaybeObserver<T>
extends AtomicInteger
implements MaybeObserver<T>,
Subscription {
    private static final long serialVersionUID = 3520831347801429610L;
    final AtomicReference<Object> current;
    final SequentialDisposable disposables;
    final Subscriber<? super T> downstream;
    int index;
    long produced;
    final AtomicLong requested;
    final MaybeSource<? extends T>[] sources;

    MaybeConcatArray.ConcatMaybeObserver(Subscriber<? super T> subscriber, MaybeSource<? extends T>[] maybeSourceArray) {
        this.downstream = subscriber;
        this.sources = maybeSourceArray;
        this.requested = new AtomicLong();
        this.disposables = new SequentialDisposable();
        this.current = new AtomicReference<NotificationLite>(NotificationLite.COMPLETE);
    }

    public void cancel() {
        this.disposables.dispose();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        AtomicReference<Object> atomicReference = this.current;
        Subscriber<? super T> subscriber = this.downstream;
        SequentialDisposable sequentialDisposable = this.disposables;
        do {
            if (sequentialDisposable.isDisposed()) {
                atomicReference.lazySet(null);
                return;
            }
            MaybeSource<? extends T>[] maybeSourceArray = atomicReference.get();
            if (maybeSourceArray == null) continue;
            NotificationLite notificationLite = NotificationLite.COMPLETE;
            int n = 1;
            if (maybeSourceArray != notificationLite) {
                long l = this.produced;
                if (l != this.requested.get()) {
                    this.produced = l + 1L;
                    atomicReference.lazySet(null);
                    subscriber.onNext(maybeSourceArray);
                } else {
                    n = 0;
                }
            } else {
                atomicReference.lazySet(null);
            }
            if (n == 0 || sequentialDisposable.isDisposed()) continue;
            n = this.index;
            maybeSourceArray = this.sources;
            if (n == maybeSourceArray.length) {
                subscriber.onComplete();
                return;
            }
            this.index = n + 1;
            maybeSourceArray[n].subscribe((MaybeObserver)this);
        } while (this.decrementAndGet() != 0);
    }

    public void onComplete() {
        this.current.lazySet(NotificationLite.COMPLETE);
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        this.disposables.replace(disposable);
    }

    public void onSuccess(T t) {
        this.current.lazySet(t);
        this.drain();
    }

    public void request(long l) {
        if (!SubscriptionHelper.validate((long)l)) return;
        BackpressureHelper.add((AtomicLong)this.requested, (long)l);
        this.drain();
    }
}
