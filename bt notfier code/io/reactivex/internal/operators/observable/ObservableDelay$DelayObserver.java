/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableDelay$DelayObserver$OnComplete
 *  io.reactivex.internal.operators.observable.ObservableDelay$DelayObserver$OnError
 *  io.reactivex.internal.operators.observable.ObservableDelay$DelayObserver$OnNext
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableDelay;
import java.util.concurrent.TimeUnit;

static final class ObservableDelay.DelayObserver<T>
implements Observer<T>,
Disposable {
    final long delay;
    final boolean delayError;
    final Observer<? super T> downstream;
    final TimeUnit unit;
    Disposable upstream;
    final Scheduler.Worker w;

    ObservableDelay.DelayObserver(Observer<? super T> observer, long l, TimeUnit timeUnit, Scheduler.Worker worker, boolean bl) {
        this.downstream = observer;
        this.delay = l;
        this.unit = timeUnit;
        this.w = worker;
        this.delayError = bl;
    }

    public void dispose() {
        this.upstream.dispose();
        this.w.dispose();
    }

    public boolean isDisposed() {
        return this.w.isDisposed();
    }

    public void onComplete() {
        this.w.schedule((Runnable)new OnComplete(this), this.delay, this.unit);
    }

    public void onError(Throwable throwable) {
        Scheduler.Worker worker = this.w;
        throwable = new OnError(this, throwable);
        long l = this.delayError ? this.delay : 0L;
        worker.schedule((Runnable)((Object)throwable), l, this.unit);
    }

    public void onNext(T t) {
        this.w.schedule((Runnable)new OnNext(this, t), this.delay, this.unit);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
