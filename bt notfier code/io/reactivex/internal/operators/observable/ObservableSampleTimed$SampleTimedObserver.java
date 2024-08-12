/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

static abstract class ObservableSampleTimed.SampleTimedObserver<T>
extends AtomicReference<T>
implements Observer<T>,
Disposable,
Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    final Observer<? super T> downstream;
    final long period;
    final Scheduler scheduler;
    final AtomicReference<Disposable> timer = new AtomicReference();
    final TimeUnit unit;
    Disposable upstream;

    ObservableSampleTimed.SampleTimedObserver(Observer<? super T> observer, long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.downstream = observer;
        this.period = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    abstract void complete();

    public void dispose() {
        this.cancelTimer();
        this.upstream.dispose();
    }

    void emit() {
        Object var1_1 = this.getAndSet(null);
        if (var1_1 == null) return;
        this.downstream.onNext(var1_1);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.cancelTimer();
        this.complete();
    }

    public void onError(Throwable throwable) {
        this.cancelTimer();
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.lazySet(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
        disposable = this.scheduler;
        long l = this.period;
        disposable = disposable.schedulePeriodicallyDirect((Runnable)this, l, l, this.unit);
        DisposableHelper.replace(this.timer, (Disposable)disposable);
    }
}
