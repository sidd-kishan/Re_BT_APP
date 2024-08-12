/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposableHelper
 *  com.uber.autodispose.AutoDisposingMaybeObserverImpl
 *  io.reactivex.observers.DisposableCompletableObserver
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposingMaybeObserverImpl;
import io.reactivex.observers.DisposableCompletableObserver;
import java.util.concurrent.atomic.AtomicReference;

class AutoDisposingMaybeObserverImpl.1
extends DisposableCompletableObserver {
    final AutoDisposingMaybeObserverImpl this$0;

    AutoDisposingMaybeObserverImpl.1(AutoDisposingMaybeObserverImpl autoDisposingMaybeObserverImpl) {
        this.this$0 = autoDisposingMaybeObserverImpl;
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
