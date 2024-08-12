/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.ErrorMode
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

static final class FlowableConcatMapCompletable.ConcatMapCompletableObserver<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Disposable {
    private static final long serialVersionUID = 3610901111000061034L;
    volatile boolean active;
    int consumed;
    volatile boolean disposed;
    volatile boolean done;
    final CompletableObserver downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapInnerObserver inner;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int prefetch;
    final SimplePlainQueue<T> queue;
    Subscription upstream;

    FlowableConcatMapCompletable.ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int n) {
        this.downstream = completableObserver;
        this.mapper = function;
        this.errorMode = errorMode;
        this.prefetch = n;
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapInnerObserver(this);
        this.queue = new SpscArrayQueue(n);
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.cancel();
        this.inner.dispose();
        if (this.getAndIncrement() != 0) return;
        this.queue.clear();
    }

    void drain() {
        if (this.getAndIncrement() != 0) {
            return;
        }
        do {
            Object object;
            if (this.disposed) {
                this.queue.clear();
                return;
            }
            if (this.active) continue;
            if (this.errorMode == ErrorMode.BOUNDARY && this.errors.get() != null) {
                this.queue.clear();
                object = this.errors.terminate();
                this.downstream.onError((Throwable)object);
                return;
            }
            boolean bl = this.done;
            object = this.queue.poll();
            int n = object == null ? 1 : 0;
            if (bl && n != 0) {
                object = this.errors.terminate();
                if (object != null) {
                    this.downstream.onError((Throwable)object);
                } else {
                    this.downstream.onComplete();
                }
                return;
            }
            if (n != 0) continue;
            n = this.prefetch;
            n = this.consumed + 1;
            int n2 = n - (n >> 1);
            if (n == n2) {
                this.consumed = 0;
                this.upstream.request((long)n2);
            } else {
                this.consumed = n;
            }
            try {
                object = (CompletableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null CompletableSource");
                this.active = true;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.queue.clear();
                this.upstream.cancel();
                this.errors.addThrowable(throwable);
                Throwable throwable2 = this.errors.terminate();
                this.downstream.onError(throwable2);
                return;
            }
            object.subscribe((CompletableObserver)this.inner);
        } while (this.decrementAndGet() != 0);
    }

    void innerComplete() {
        this.active = false;
        this.drain();
    }

    void innerError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.upstream.cancel();
                throwable = this.errors.terminate();
                if (throwable != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(throwable);
                }
                if (this.getAndIncrement() != 0) return;
                this.queue.clear();
            } else {
                this.active = false;
                this.drain();
            }
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.inner.dispose();
                throwable = this.errors.terminate();
                if (throwable != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(throwable);
                }
                if (this.getAndIncrement() != 0) return;
                this.queue.clear();
            } else {
                this.done = true;
                this.drain();
            }
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (this.queue.offer(t)) {
            this.drain();
        } else {
            this.upstream.cancel();
            this.onError((Throwable)new MissingBackpressureException("Queue full?!"));
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Disposable)this);
        subscription.request((long)this.prefetch);
    }
}
