/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutSupport
 *  io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutTask
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableTimeoutTimed.TimeoutObserver<T>
extends AtomicLong
implements Observer<T>,
Disposable,
ObservableTimeoutTimed.TimeoutSupport {
    private static final long serialVersionUID = 3764492702657003550L;
    final Observer<? super T> downstream;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<Disposable> upstream;
    final Scheduler.Worker worker;

    ObservableTimeoutTimed.TimeoutObserver(Observer<? super T> observer, long l, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.downstream = observer;
        this.timeout = l;
        this.unit = timeUnit;
        this.worker = worker;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        this.worker.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)this.upstream.get());
    }

    public void onComplete() {
        if (this.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) return;
        this.task.dispose();
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable throwable) {
        if (this.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(throwable);
            this.worker.dispose();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        long l = this.get();
        if (l == Long.MAX_VALUE) return;
        long l2 = 1L + l;
        if (!this.compareAndSet(l, l2)) return;
        ((Disposable)this.task.get()).dispose();
        this.downstream.onNext(t);
        this.startTimeout(l2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.upstream, (Disposable)disposable);
    }

    public void onTimeout(long l) {
        if (!this.compareAndSet(l, Long.MAX_VALUE)) return;
        DisposableHelper.dispose(this.upstream);
        this.downstream.onError((Throwable)new TimeoutException(ExceptionHelper.timeoutMessage((long)this.timeout, (TimeUnit)this.unit)));
        this.worker.dispose();
    }

    void startTimeout(long l) {
        this.task.replace(this.worker.schedule((Runnable)new ObservableTimeoutTimed.TimeoutTask(l, (ObservableTimeoutTimed.TimeoutSupport)this), this.timeout, this.unit));
    }
}
