/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposableHelper
 *  com.uber.autodispose.AutoDisposeEndConsumerHelper
 *  com.uber.autodispose.AutoDisposingSingleObserverImpl$1
 *  com.uber.autodispose.observers.AutoDisposingSingleObserver
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposeEndConsumerHelper;
import com.uber.autodispose.AutoDisposingSingleObserverImpl;
import com.uber.autodispose.observers.AutoDisposingSingleObserver;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

final class AutoDisposingSingleObserverImpl<T>
implements AutoDisposingSingleObserver<T> {
    private final SingleObserver<? super T> delegate;
    final AtomicReference<Disposable> mainDisposable = new AtomicReference();
    private final CompletableSource scope;
    final AtomicReference<Disposable> scopeDisposable = new AtomicReference();

    AutoDisposingSingleObserverImpl(CompletableSource completableSource, SingleObserver<? super T> singleObserver) {
        this.scope = completableSource;
        this.delegate = singleObserver;
    }

    public SingleObserver<? super T> delegateObserver() {
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
