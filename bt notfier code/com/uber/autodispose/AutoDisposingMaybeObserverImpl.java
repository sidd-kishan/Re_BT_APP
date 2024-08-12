/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposableHelper
 *  com.uber.autodispose.AutoDisposeEndConsumerHelper
 *  com.uber.autodispose.AutoDisposingMaybeObserverImpl$1
 *  com.uber.autodispose.observers.AutoDisposingMaybeObserver
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposeEndConsumerHelper;
import com.uber.autodispose.AutoDisposingMaybeObserverImpl;
import com.uber.autodispose.observers.AutoDisposingMaybeObserver;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

final class AutoDisposingMaybeObserverImpl<T>
implements AutoDisposingMaybeObserver<T> {
    private final MaybeObserver<? super T> delegate;
    final AtomicReference<Disposable> mainDisposable = new AtomicReference();
    private final CompletableSource scope;
    final AtomicReference<Disposable> scopeDisposable = new AtomicReference();

    AutoDisposingMaybeObserverImpl(CompletableSource completableSource, MaybeObserver<? super T> maybeObserver) {
        this.scope = completableSource;
        this.delegate = maybeObserver;
    }

    public MaybeObserver<? super T> delegateObserver() {
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
        this.delegate.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.isDisposed()) return;
        this.mainDisposable.lazySet((Disposable)AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        this.delegate.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        1 var2_2 = new /* Unavailable Anonymous Inner Class!! */;
        if (!AutoDisposeEndConsumerHelper.setOnce(this.scopeDisposable, (Disposable)var2_2, this.getClass())) return;
        this.delegate.onSubscribe((Disposable)this);
        this.scope.subscribe((CompletableObserver)var2_2);
        AutoDisposeEndConsumerHelper.setOnce(this.mainDisposable, (Disposable)disposable, this.getClass());
    }

    public void onSuccess(T t) {
        if (this.isDisposed()) return;
        this.mainDisposable.lazySet((Disposable)AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose(this.scopeDisposable);
        this.delegate.onSuccess(t);
    }
}
