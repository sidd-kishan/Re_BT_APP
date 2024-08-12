/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableDebounceTimed$DebounceEmitter
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

static final class ObservableDebounceTimed.DebounceTimedObserver<T>
implements Observer<T>,
Disposable {
    boolean done;
    final Observer<? super T> downstream;
    volatile long index;
    final long timeout;
    Disposable timer;
    final TimeUnit unit;
    Disposable upstream;
    final Scheduler.Worker worker;

    ObservableDebounceTimed.DebounceTimedObserver(Observer<? super T> observer, long l, TimeUnit timeUnit, Scheduler.Worker worker) {
        this.downstream = observer;
        this.timeout = l;
        this.unit = timeUnit;
        this.worker = worker;
    }

    public void dispose() {
        this.upstream.dispose();
        this.worker.dispose();
    }

    void emit(long l, T t, ObservableDebounceTimed.DebounceEmitter<T> debounceEmitter) {
        if (l != this.index) return;
        this.downstream.onNext(t);
        debounceEmitter.dispose();
    }

    public boolean isDisposed() {
        return this.worker.isDisposed();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        Disposable disposable = this.timer;
        if (disposable != null) {
            disposable.dispose();
        }
        if ((disposable = (ObservableDebounceTimed.DebounceEmitter)disposable) != null) {
            disposable.run();
        }
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        Disposable disposable = this.timer;
        if (disposable != null) {
            disposable.dispose();
        }
        this.done = true;
        this.downstream.onError(throwable);
        this.worker.dispose();
    }

    public void onNext(T object) {
        long l;
        if (this.done) {
            return;
        }
        this.index = l = this.index + 1L;
        Disposable disposable = this.timer;
        if (disposable != null) {
            disposable.dispose();
        }
        object = new ObservableDebounceTimed.DebounceEmitter(object, l, this);
        this.timer = object;
        object.setResource(this.worker.schedule(object, this.timeout, this.unit));
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
