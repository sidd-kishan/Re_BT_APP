/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposableHelper
 *  com.uber.autodispose.AutoDisposingSingleObserverImpl
 *  io.reactivex.observers.DisposableCompletableObserver
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposingSingleObserverImpl;
import io.reactivex.observers.DisposableCompletableObserver;
import java.util.concurrent.atomic.AtomicReference;

class AutoDisposingSingleObserverImpl.1
extends DisposableCompletableObserver {
    final AutoDisposingSingleObserverImpl this$0;

    AutoDisposingSingleObserverImpl.1(AutoDisposingSingleObserverImpl autoDisposingSingleObserverImpl) {
        this.this$0 = autoDisposingSingleObserverImpl;
    }

    public void onComplete() {
        this.this$0.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
        AutoDisposableHelper.dispose((AtomicReference)this.this$0.mainDisposable);
    }

    public void onError(Throwable throwable) {
        this.this$0.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
        this.this$0.onError(throwable);
    }
}
