/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutConsumer
 *  io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutSelectorSupport
 *  io.reactivex.internal.operators.observable.ObservableTimeoutTimed$FallbackObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableTimeout.TimeoutFallbackObserver<T>
extends AtomicReference<Disposable>
implements Observer<T>,
Disposable,
ObservableTimeout.TimeoutSelectorSupport {
    private static final long serialVersionUID = -7508389464265974549L;
    final Observer<? super T> downstream;
    ObservableSource<? extends T> fallback;
    final AtomicLong index;
    final Function<? super T, ? extends ObservableSource<?>> itemTimeoutIndicator;
    final SequentialDisposable task;
    final AtomicReference<Disposable> upstream;

    ObservableTimeout.TimeoutFallbackObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function, ObservableSource<? extends T> observableSource) {
        this.downstream = observer;
        this.itemTimeoutIndicator = function;
        this.task = new SequentialDisposable();
        this.fallback = observableSource;
        this.index = new AtomicLong();
        this.upstream = new AtomicReference();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose((AtomicReference)this);
        this.task.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) return;
        this.task.dispose();
        this.downstream.onComplete();
        this.task.dispose();
    }

    public void onError(Throwable throwable) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(throwable);
            this.task.dispose();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        block3: {
            long l = this.index.get();
            if (l == Long.MAX_VALUE) return;
            AtomicLong atomicLong = this.index;
            long l2 = 1L + l;
            if (!atomicLong.compareAndSet(l, l2)) return;
            atomicLong = (Disposable)this.task.get();
            if (atomicLong != null) {
                atomicLong.dispose();
            }
            this.downstream.onNext(object);
            try {
                object = (ObservableSource)ObjectHelper.requireNonNull((Object)this.itemTimeoutIndicator.apply(object), (String)"The itemTimeoutIndicator returned a null ObservableSource.");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.get().dispose();
                this.index.getAndSet(Long.MAX_VALUE);
                this.downstream.onError(throwable);
                break block3;
            }
            atomicLong = new ObservableTimeout.TimeoutConsumer(l2, (ObservableTimeout.TimeoutSelectorSupport)this);
            if (!this.task.replace((Disposable)atomicLong)) return;
            object.subscribe((Observer)atomicLong);
            return;
        }
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
    }

    public void onTimeoutError(long l, Throwable throwable) {
        if (this.index.compareAndSet(l, Long.MAX_VALUE)) {
            DisposableHelper.dispose((AtomicReference)this);
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void startFirstTimeout(ObservableSource<?> observableSource) {
        if (observableSource == null) return;
        ObservableTimeout.TimeoutConsumer timeoutConsumer = new ObservableTimeout.TimeoutConsumer(0L, (ObservableTimeout.TimeoutSelectorSupport)this);
        if (!this.task.replace((Disposable)timeoutConsumer)) return;
        observableSource.subscribe((Observer)timeoutConsumer);
    }
}
