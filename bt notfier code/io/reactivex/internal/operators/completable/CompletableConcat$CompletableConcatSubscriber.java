/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.completable.CompletableConcat$CompletableConcatSubscriber$ConcatInnerObserver
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.queue.SpscLinkedArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.completable.CompletableConcat;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class CompletableConcat.CompletableConcatSubscriber
extends AtomicInteger
implements FlowableSubscriber<CompletableSource>,
Disposable {
    private static final long serialVersionUID = 9032184911934499404L;
    volatile boolean active;
    int consumed;
    volatile boolean done;
    final CompletableObserver downstream;
    final ConcatInnerObserver inner;
    final int limit;
    final AtomicBoolean once;
    final int prefetch;
    SimpleQueue<CompletableSource> queue;
    int sourceFused;
    Subscription upstream;

    CompletableConcat.CompletableConcatSubscriber(CompletableObserver completableObserver, int n) {
        this.downstream = completableObserver;
        this.prefetch = n;
        this.inner = new ConcatInnerObserver(this);
        this.once = new AtomicBoolean();
        this.limit = n - (n >> 2);
    }

    public void dispose() {
        this.upstream.cancel();
        DisposableHelper.dispose((AtomicReference)this.inner);
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        do {
            boolean bl;
            CompletableSource completableSource;
            block5: {
                if (this.isDisposed()) {
                    return;
                }
                if (this.active) continue;
                boolean bl2 = this.done;
                try {
                    completableSource = (CompletableSource)this.queue.poll();
                    bl = completableSource == null;
                    if (!bl2 || !bl) break block5;
                    if (!this.once.compareAndSet(false, true)) return;
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.innerError(throwable);
                    return;
                }
                this.downstream.onComplete();
                return;
            }
            if (bl) continue;
            this.active = true;
            completableSource.subscribe((CompletableObserver)this.inner);
            this.request();
        } while (this.decrementAndGet() != 0);
    }

    void innerComplete() {
        this.active = false;
        this.drain();
    }

    void innerError(Throwable throwable) {
        if (this.once.compareAndSet(false, true)) {
            this.upstream.cancel();
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.inner.get()));
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose((AtomicReference)this.inner);
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(CompletableSource completableSource) {
        if (this.sourceFused == 0 && !this.queue.offer((Object)completableSource)) {
            this.onError((Throwable)new MissingBackpressureException());
            return;
        }
        this.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        int n = this.prefetch;
        long l = n == Integer.MAX_VALUE ? Long.MAX_VALUE : (long)n;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            n = queueSubscription.requestFusion(3);
            if (n == 1) {
                this.sourceFused = n;
                this.queue = queueSubscription;
                this.done = true;
                this.downstream.onSubscribe((Disposable)this);
                this.drain();
                return;
            }
            if (n == 2) {
                this.sourceFused = n;
                this.queue = queueSubscription;
                this.downstream.onSubscribe((Disposable)this);
                subscription.request(l);
                return;
            }
        }
        this.queue = this.prefetch == Integer.MAX_VALUE ? new SpscLinkedArrayQueue(Flowable.bufferSize()) : new SpscArrayQueue(this.prefetch);
        this.downstream.onSubscribe((Disposable)this);
        subscription.request(l);
    }

    void request() {
        if (this.sourceFused == 1) return;
        int n = this.consumed + 1;
        if (n == this.limit) {
            this.consumed = 0;
            this.upstream.request((long)n);
        } else {
            this.consumed = n;
        }
    }
}
