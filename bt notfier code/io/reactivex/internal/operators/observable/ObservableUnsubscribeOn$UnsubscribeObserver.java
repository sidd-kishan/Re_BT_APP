/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableUnsubscribeOn$UnsubscribeObserver$DisposeTask
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

static final class ObservableUnsubscribeOn.UnsubscribeObserver<T>
extends AtomicBoolean
implements Observer<T>,
Disposable {
    private static final long serialVersionUID = 1015244841293359600L;
    final Observer<? super T> downstream;
    final Scheduler scheduler;
    Disposable upstream;

    ObservableUnsubscribeOn.UnsubscribeObserver(Observer<? super T> observer, Scheduler scheduler) {
        this.downstream = observer;
        this.scheduler = scheduler;
    }

    public void dispose() {
        if (!this.compareAndSet(false, true)) return;
        this.scheduler.scheduleDirect((Runnable)new DisposeTask(this));
    }

    public boolean isDisposed() {
        return this.get();
    }

    public void onComplete() {
        if (this.get()) return;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.get()) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.get()) return;
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
