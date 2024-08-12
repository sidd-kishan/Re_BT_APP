/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableThrottleFirstTimed.DebounceTimedObserver<T>
extends AtomicReference<Disposable>
implements Observer<T>,
Disposable,
Runnable {
    private static final long serialVersionUID = 786994795061867455L;
    boolean done;
    final Observer<? super T> downstream;
    volatile boolean gate;
    final long timeout;
    final TimeUnit unit;
    Disposable upstream;
    final Scheduler.Worker worker;

    ObservableThrottleFirstTimed.DebounceTimedObserver(Observer<? super T> observer, long l, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.downstream = observer;
        this.timeout = l;
        this.unit = timeUnit;
        this.worker = worker;
    }

    public void dispose() {
        this.upstream.dispose();
        this.worker.dispose();
    }

    public boolean isDisposed() {
        return this.worker.isDisposed();
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
        } else {
            this.done = true;
            this.downstream.onError(throwable);
            this.worker.dispose();
        }
    }

    public void onNext(T object) {
        if (this.gate) return;
        if (this.done) return;
        this.gate = true;
        this.downstream.onNext(object);
        object = (Disposable)this.get();
        if (object != null) {
            object.dispose();
        }
        DisposableHelper.replace((AtomicReference)this, (Disposable)this.worker.schedule((Runnable)this, this.timeout, this.unit));
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    @Override
    public void run() {
        this.gate = false;
    }
}
