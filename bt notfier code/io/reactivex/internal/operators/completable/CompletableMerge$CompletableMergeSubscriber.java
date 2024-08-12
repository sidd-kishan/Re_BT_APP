/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.completable.CompletableMerge$CompletableMergeSubscriber$MergeInnerObserver
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.completable.CompletableMerge;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

static final class CompletableMerge.CompletableMergeSubscriber
extends AtomicInteger
implements FlowableSubscriber<CompletableSource>,
Disposable {
    private static final long serialVersionUID = -2108443387387077490L;
    final boolean delayErrors;
    final CompletableObserver downstream;
    final AtomicThrowable error;
    final int maxConcurrency;
    final CompositeDisposable set;
    Subscription upstream;

    CompletableMerge.CompletableMergeSubscriber(CompletableObserver completableObserver, int n, boolean bl) {
        this.downstream = completableObserver;
        this.maxConcurrency = n;
        this.delayErrors = bl;
        this.set = new CompositeDisposable();
        this.error = new AtomicThrowable();
        this.lazySet(1);
    }

    public void dispose() {
        this.upstream.cancel();
        this.set.dispose();
    }

    void innerComplete(MergeInnerObserver object) {
        this.set.delete((Disposable)object);
        if (this.decrementAndGet() == 0) {
            object = (Throwable)this.error.get();
            if (object != null) {
                this.downstream.onError((Throwable)object);
            } else {
                this.downstream.onComplete();
            }
        } else {
            if (this.maxConcurrency == Integer.MAX_VALUE) return;
            this.upstream.request(1L);
        }
    }

    void innerError(MergeInnerObserver mergeInnerObserver, Throwable throwable) {
        this.set.delete((Disposable)mergeInnerObserver);
        if (!this.delayErrors) {
            this.upstream.cancel();
            this.set.dispose();
            if (this.error.addThrowable(throwable)) {
                if (this.getAndSet(0) <= 0) return;
                this.downstream.onError(this.error.terminate());
            } else {
                RxJavaPlugins.onError((Throwable)throwable);
            }
        } else if (this.error.addThrowable(throwable)) {
            if (this.decrementAndGet() == 0) {
                this.downstream.onError(this.error.terminate());
            } else {
                if (this.maxConcurrency == Integer.MAX_VALUE) return;
                this.upstream.request(1L);
            }
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public boolean isDisposed() {
        return this.set.isDisposed();
    }

    public void onComplete() {
        if (this.decrementAndGet() != 0) return;
        if ((Throwable)this.error.get() != null) {
            this.downstream.onError(this.error.terminate());
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        if (!this.delayErrors) {
            this.set.dispose();
            if (this.error.addThrowable(throwable)) {
                if (this.getAndSet(0) <= 0) return;
                this.downstream.onError(this.error.terminate());
            } else {
                RxJavaPlugins.onError((Throwable)throwable);
            }
        } else if (this.error.addThrowable(throwable)) {
            if (this.decrementAndGet() != 0) return;
            this.downstream.onError(this.error.terminate());
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(CompletableSource completableSource) {
        this.getAndIncrement();
        MergeInnerObserver mergeInnerObserver = new MergeInnerObserver(this);
        this.set.add((Disposable)mergeInnerObserver);
        completableSource.subscribe((CompletableObserver)mergeInnerObserver);
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
