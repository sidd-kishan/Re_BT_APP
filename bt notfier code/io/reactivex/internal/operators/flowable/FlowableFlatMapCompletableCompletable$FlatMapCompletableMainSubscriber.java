/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber$InnerObserver
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

static final class FlowableFlatMapCompletableCompletable.FlatMapCompletableMainSubscriber<T>
extends AtomicInteger
implements FlowableSubscriber<T>,
Disposable {
    private static final long serialVersionUID = 8443155186132538303L;
    final boolean delayErrors;
    volatile boolean disposed;
    final CompletableObserver downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int maxConcurrency;
    final CompositeDisposable set;
    Subscription upstream;

    FlowableFlatMapCompletableCompletable.FlatMapCompletableMainSubscriber(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean bl, int n) {
        this.downstream = completableObserver;
        this.mapper = function;
        this.delayErrors = bl;
        this.errors = new AtomicThrowable();
        this.set = new CompositeDisposable();
        this.maxConcurrency = n;
        this.lazySet(1);
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    void innerComplete(InnerObserver innerObserver) {
        this.set.delete((Disposable)innerObserver);
        this.onComplete();
    }

    void innerError(InnerObserver innerObserver, Throwable throwable) {
        this.set.delete((Disposable)innerObserver);
        this.onError(throwable);
    }

    public boolean isDisposed() {
        return this.set.isDisposed();
    }

    public void onComplete() {
        if (this.decrementAndGet() == 0) {
            Throwable throwable = this.errors.terminate();
            if (throwable != null) {
                this.downstream.onError(throwable);
            } else {
                this.downstream.onComplete();
            }
        } else {
            if (this.maxConcurrency == Integer.MAX_VALUE) return;
            this.upstream.request(1L);
        }
    }

    public void onError(Throwable throwable) {
        if (this.errors.addThrowable(throwable)) {
            if (this.delayErrors) {
                if (this.decrementAndGet() == 0) {
                    throwable = this.errors.terminate();
                    this.downstream.onError(throwable);
                } else {
                    if (this.maxConcurrency == Integer.MAX_VALUE) return;
                    this.upstream.request(1L);
                }
            } else {
                this.dispose();
                if (this.getAndSet(0) <= 0) return;
                throwable = this.errors.terminate();
                this.downstream.onError(throwable);
            }
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        CompletableSource completableSource;
        try {
            completableSource = (CompletableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null CompletableSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        this.getAndIncrement();
        object = new InnerObserver(this);
        if (this.disposed) return;
        if (!this.set.add(object)) return;
        completableSource.subscribe(object);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Disposable)this);
        int n = this.maxConcurrency;
        if (n == Integer.MAX_VALUE) {
            subscription.request(Long.MAX_VALUE);
        } else {
            subscription.request((long)n);
        }
    }
}
