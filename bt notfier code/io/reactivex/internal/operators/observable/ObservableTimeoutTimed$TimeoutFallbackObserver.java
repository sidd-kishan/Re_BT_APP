/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.operators.observable.ObservableTimeoutTimed$FallbackObserver
 *  io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutSupport
 *  io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutTask
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableTimeoutTimed.TimeoutFallbackObserver<T>
extends AtomicReference<Disposable>
implements Observer<T>,
Disposable,
ObservableTimeoutTimed.TimeoutSupport {
    private static final long serialVersionUID = 3764492702657003550L;
    final Observer<? super T> downstream;
    ObservableSource<? extends T> fallback;
    final AtomicLong index;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<Disposable> upstream;
    final Scheduler.Worker worker;

    ObservableTimeoutTimed.TimeoutFallbackObserver(Observer<? super T> observer, long l, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource<? extends T> observableSource) {
        this.downstream = observer;
        this.timeout = l;
        this.unit = timeUnit;
        this.worker = worker;
        this.fallback = observableSource;
        this.task = new SequentialDisposable();
        this.index = new AtomicLong();
        this.upstream = new AtomicReference();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose((AtomicReference)this);
        this.worker.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) return;
        this.task.dispose();
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable throwable) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(throwable);
            this.worker.dispose();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        long l = this.index.get();
        if (l == Long.MAX_VALUE) return;
        AtomicLong atomicLong = this.index;
        long l2 = 1L + l;
        if (!atomicLong.compareAndSet(l, l2)) return;
        ((Disposable)this.task.get()).dispose();
        this.downstream.onNext(t);
        this.startTimeout(l2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.upstream, (Disposable)disposable);
    }

    public void onTimeout(long l) {
        if (!this.index.compareAndSet(l, Long.MAX_VALUE)) return;
        DisposableHelper.dispose(this.upstream);
        ObservableSource<? extends T> observableSource = this.fallback;
        this.fallback = null;
        observableSource.subscribe((Observer)new ObservableTimeoutTimed.FallbackObserver(this.downstream, (AtomicReference)this));
        this.worker.dispose();
    }

    void startTimeout(long l) {
        this.task.replace(this.worker.schedule((Runnable)new ObservableTimeoutTimed.TimeoutTask(l, (ObservableTimeoutTimed.TimeoutSupport)this), this.timeout, this.unit));
    }
}
