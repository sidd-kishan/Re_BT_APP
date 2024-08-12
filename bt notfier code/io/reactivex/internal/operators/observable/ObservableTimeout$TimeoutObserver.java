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
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableTimeout.TimeoutObserver<T>
extends AtomicLong
implements Observer<T>,
Disposable,
ObservableTimeout.TimeoutSelectorSupport {
    private static final long serialVersionUID = 3764492702657003550L;
    final Observer<? super T> downstream;
    final Function<? super T, ? extends ObservableSource<?>> itemTimeoutIndicator;
    final SequentialDisposable task;
    final AtomicReference<Disposable> upstream;

    ObservableTimeout.TimeoutObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function) {
        this.downstream = observer;
        this.itemTimeoutIndicator = function;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        this.task.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)this.upstream.get());
    }

    public void onComplete() {
        if (this.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) return;
        this.task.dispose();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T object) {
        block3: {
            long l = this.get();
            if (l == Long.MAX_VALUE) return;
            long l2 = 1L + l;
            if (!this.compareAndSet(l, l2)) return;
            Disposable disposable = (Disposable)this.task.get();
            if (disposable != null) {
                disposable.dispose();
            }
            this.downstream.onNext(object);
            try {
                object = (ObservableSource)ObjectHelper.requireNonNull((Object)this.itemTimeoutIndicator.apply(object), (String)"The itemTimeoutIndicator returned a null ObservableSource.");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.get().dispose();
                this.getAndSet(Long.MAX_VALUE);
                this.downstream.onError(throwable);
                break block3;
            }
            disposable = new ObservableTimeout.TimeoutConsumer(l2, (ObservableTimeout.TimeoutSelectorSupport)this);
            if (!this.task.replace(disposable)) return;
            object.subscribe((Observer)disposable);
            return;
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.upstream, (Disposable)disposable);
    }

    public void onTimeout(long l) {
        if (!this.compareAndSet(l, Long.MAX_VALUE)) return;
        DisposableHelper.dispose(this.upstream);
        this.downstream.onError((Throwable)new TimeoutException());
    }

    public void onTimeoutError(long l, Throwable throwable) {
        if (this.compareAndSet(l, Long.MAX_VALUE)) {
            DisposableHelper.dispose(this.upstream);
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
