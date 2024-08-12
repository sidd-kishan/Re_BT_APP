/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.schedulers.Timed
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

static final class ObservableTimeInterval.TimeIntervalObserver<T>
implements Observer<T>,
Disposable {
    final Observer<? super Timed<T>> downstream;
    long lastTime;
    final Scheduler scheduler;
    final TimeUnit unit;
    Disposable upstream;

    ObservableTimeInterval.TimeIntervalObserver(Observer<? super Timed<T>> observer, TimeUnit timeUnit, Scheduler scheduler) {
        this.downstream = observer;
        this.scheduler = scheduler;
        this.unit = timeUnit;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        long l = this.scheduler.now(this.unit);
        long l2 = this.lastTime;
        this.lastTime = l;
        this.downstream.onNext((Object)new Timed(t, l - l2, this.unit));
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.lastTime = this.scheduler.now(this.unit);
        this.downstream.onSubscribe((Disposable)this);
    }
}
