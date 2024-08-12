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
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber$InnerConsumer
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
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
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletable;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableFlatMapCompletable.FlatMapCompletableMainSubscriber<T>
extends BasicIntQueueSubscription<T>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 8443155186132538303L;
    volatile boolean cancelled;
    final boolean delayErrors;
    final Subscriber<? super T> downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int maxConcurrency;
    final CompositeDisposable set;
    Subscription upstream;

    FlowableFlatMapCompletable.FlatMapCompletableMainSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends CompletableSource> function, boolean bl, int n) {
        this.downstream = subscriber;
        this.mapper = function;
        this.delayErrors = bl;
        this.errors = new AtomicThrowable();
        this.set = new CompositeDisposable();
        this.maxConcurrency = n;
        this.lazySet(1);
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    public void clear() {
    }

    void innerComplete(InnerConsumer innerConsumer) {
        this.set.delete((Disposable)innerConsumer);
        this.onComplete();
    }

    void innerError(InnerConsumer innerConsumer, Throwable throwable) {
        this.set.delete((Disposable)innerConsumer);
        this.onError(throwable);
    }

    public boolean isEmpty() {
        return true;
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
                this.cancel();
                if (this.getAndSet(0) <= 0) return;
                throwable = this.errors.terminate();
                this.downstream.onError(throwable);
            }
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        try {
            object = (CompletableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null CompletableSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        this.getAndIncrement();
        InnerConsumer innerConsumer = new InnerConsumer(this);
        if (this.cancelled) return;
        if (!this.set.add((Disposable)innerConsumer)) return;
        object.subscribe((CompletableObserver)innerConsumer);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
        int n = this.maxConcurrency;
        if (n == Integer.MAX_VALUE) {
            subscription.request(Long.MAX_VALUE);
        } else {
            subscription.request((long)n);
        }
    }

    public T poll() throws Exception {
        return null;
    }

    public void request(long l) {
    }

    public int requestFusion(int n) {
        return n & 2;
    }
}
