/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.functions.ObjectHelper
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
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class MaybeConcatIterable.ConcatMaybeObserver<T>
extends AtomicInteger
implements MaybeObserver<T>,
Subscription {
    private static final long serialVersionUID = 3520831347801429610L;
    final AtomicReference<Object> current;
    final SequentialDisposable disposables;
    final Subscriber<? super T> downstream;
    long produced;
    final AtomicLong requested;
    final Iterator<? extends MaybeSource<? extends T>> sources;

    MaybeConcatIterable.ConcatMaybeObserver(Subscriber<? super T> subscriber, Iterator<? extends MaybeSource<? extends T>> iterator) {
        this.downstream = subscriber;
        this.sources = iterator;
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
            block11: {
                if (sequentialDisposable.isDisposed()) {
                    atomicReference.lazySet(null);
                    return;
                }
                Object object = atomicReference.get();
                if (object == null) continue;
                NotificationLite notificationLite = NotificationLite.COMPLETE;
                boolean bl = true;
                if (object != notificationLite) {
                    long l = this.produced;
                    if (l != this.requested.get()) {
                        this.produced = l + 1L;
                        atomicReference.lazySet(null);
                        subscriber.onNext(object);
                    } else {
                        bl = false;
                    }
                } else {
                    atomicReference.lazySet(null);
                }
                if (!bl || sequentialDisposable.isDisposed()) continue;
                try {
                    boolean bl2 = this.sources.hasNext();
                    if (!bl2) break block11;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    subscriber.onError(throwable);
                    return;
                }
                try {
                    notificationLite = (MaybeSource)ObjectHelper.requireNonNull(this.sources.next(), (String)"The source Iterator returned a null MaybeSource");
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    subscriber.onError(throwable);
                    return;
                }
                notificationLite.subscribe((MaybeObserver)this);
                continue;
            }
            subscriber.onComplete();
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
