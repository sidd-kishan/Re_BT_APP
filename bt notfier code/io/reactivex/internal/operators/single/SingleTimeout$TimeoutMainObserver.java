/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.single.SingleTimeout$TimeoutMainObserver$TimeoutFallbackObserver
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleTimeout.TimeoutMainObserver<T>
extends AtomicReference<Disposable>
implements SingleObserver<T>,
Runnable,
Disposable {
    private static final long serialVersionUID = 37497744973048446L;
    final SingleObserver<? super T> downstream;
    final TimeoutFallbackObserver<T> fallback;
    SingleSource<? extends T> other;
    final AtomicReference<Disposable> task;
    final long timeout;
    final TimeUnit unit;

    SingleTimeout.TimeoutMainObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource, long l, TimeUnit timeUnit) {
        this.downstream = singleObserver;
        this.other = singleSource;
        this.timeout = l;
        this.unit = timeUnit;
        this.task = new AtomicReference();
        this.fallback = singleSource != null ? new TimeoutFallbackObserver(singleObserver) : null;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
        DisposableHelper.dispose(this.task);
        TimeoutFallbackObserver<T> timeoutFallbackObserver = this.fallback;
        if (timeoutFallbackObserver == null) return;
        DisposableHelper.dispose(timeoutFallbackObserver);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onError(Throwable throwable) {
        Disposable disposable = (Disposable)this.get();
        if (disposable != DisposableHelper.DISPOSED && this.compareAndSet(disposable, DisposableHelper.DISPOSED)) {
            DisposableHelper.dispose(this.task);
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        Disposable disposable = (Disposable)this.get();
        if (disposable == DisposableHelper.DISPOSED) return;
        if (!this.compareAndSet(disposable, DisposableHelper.DISPOSED)) return;
        DisposableHelper.dispose(this.task);
        this.downstream.onSuccess(t);
    }

    @Override
    public void run() {
        SingleSource<? extends T> singleSource = (SingleSource<? extends T>)this.get();
        if (singleSource == DisposableHelper.DISPOSED) return;
        if (!this.compareAndSet(singleSource, DisposableHelper.DISPOSED)) return;
        if (singleSource != null) {
            singleSource.dispose();
        }
        if ((singleSource = this.other) == null) {
            this.downstream.onError((Throwable)new TimeoutException(ExceptionHelper.timeoutMessage((long)this.timeout, (TimeUnit)this.unit)));
        } else {
            this.other = null;
            singleSource.subscribe(this.fallback);
        }
    }
}
