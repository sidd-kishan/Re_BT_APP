/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AtomicThrowable
 *  com.uber.autodispose.AutoDisposableHelper
 *  com.uber.autodispose.AutoDisposeEndConsumerHelper
 *  com.uber.autodispose.AutoDisposingObserverImpl$1
 *  com.uber.autodispose.HalfSerializer
 *  com.uber.autodispose.observers.AutoDisposingObserver
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 */
package com.uber.autodispose;

import com.uber.autodispose.AtomicThrowable;
import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposeEndConsumerHelper;
import com.uber.autodispose.AutoDisposingObserverImpl;
import com.uber.autodispose.HalfSerializer;
import com.uber.autodispose.observers.AutoDisposingObserver;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class AutoDisposingObserverImpl<T>
extends AtomicInteger
implements AutoDisposingObserver<T> {
    private final Observer<? super T> delegate;
    private final AtomicThrowable error;
    final AtomicReference<Disposable> mainDisposable = new AtomicReference();
    private final CompletableSource scope;
    final AtomicReference<Disposable> scopeDisposable = new AtomicReference();

    AutoDisposingObserverImpl(CompletableSource completableSource, Observer<? super T> observer) {
        this.error = new AtomicThrowable();
        this.scope = completableSource;
        this.delegate = observer;
    }

    public Observer<? super T> delegateObserver() {
        return this.delegate;
    }

    public void dispose() {
        AutoDisposableHelper.dispose(this.scopeDisposable);
        AutoDisposableHelper.dispose(this.mainDisposable);
    }

    public boolean isDisposed() {
        boolean bl = this.mainDisposable.get() == AutoDisposableHelper.DISPOSED;
        return bl;
    }

    public void onComplete() {
        if (this.isDisposed()) return;
        this.mainDisposable.lazySet((Disposable)AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        HalfSerializer.onComplete(this.delegate, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onError(Throwable throwable) {
        if (this.isDisposed()) return;
        this.mainDisposable.lazySet((Disposable)AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        HalfSerializer.onError(this.delegate, (Throwable)throwable, (AtomicInteger)this, (AtomicThrowable)this.error);
    }

    public void onNext(T t) {
        if (this.isDisposed()) return;
        if (!HalfSerializer.onNext(this.delegate, t, (AtomicInteger)this, (AtomicThrowable)this.error)) return;
        this.mainDisposable.lazySet((Disposable)AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
    }

    public void onSubscribe(Disposable disposable) {
        1 var2_2 = new /* Unavailable Anonymous Inner Class!! */;
        if (!AutoDisposeEndConsumerHelper.setOnce(this.scopeDisposable, (Disposable)var2_2, this.getClass())) return;
        this.delegate.onSubscribe((Disposable)this);
        this.scope.subscribe((CompletableObserver)var2_2);
        AutoDisposeEndConsumerHelper.setOnce(this.mainDisposable, (Disposable)disposable, this.getClass());
    }
}
