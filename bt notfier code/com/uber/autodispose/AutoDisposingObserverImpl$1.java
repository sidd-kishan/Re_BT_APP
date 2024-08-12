/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposableHelper
 *  com.uber.autodispose.AutoDisposingObserverImpl
 *  io.reactivex.observers.DisposableCompletableObserver
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposingObserverImpl;
import io.reactivex.observers.DisposableCompletableObserver;
import java.util.concurrent.atomic.AtomicReference;

class AutoDisposingObserverImpl.1
extends DisposableCompletableObserver {
    final AutoDisposingObserverImpl this$0;

    AutoDisposingObserverImpl.1(AutoDisposingObserverImpl autoDisposingObserverImpl) {
        this.this$0 = autoDisposingObserverImpl;
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
