/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposableHelper
 *  com.uber.autodispose.AutoDisposingSubscriberImpl
 *  com.uber.autodispose.AutoSubscriptionHelper
 *  io.reactivex.observers.DisposableCompletableObserver
 */
package com.uber.autodispose;

import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoDisposingSubscriberImpl;
import com.uber.autodispose.AutoSubscriptionHelper;
import io.reactivex.observers.DisposableCompletableObserver;
import java.util.concurrent.atomic.AtomicReference;

class AutoDisposingSubscriberImpl.1
extends DisposableCompletableObserver {
    final AutoDisposingSubscriberImpl this$0;

    AutoDisposingSubscriberImpl.1(AutoDisposingSubscriberImpl autoDisposingSubscriberImpl) {
        this.this$0 = autoDisposingSubscriberImpl;
    }

    public void onComplete() {
        this.this$0.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
        AutoSubscriptionHelper.cancel((AtomicReference)this.this$0.mainSubscription);
    }

    public void onError(Throwable throwable) {
        this.this$0.scopeDisposable.lazySet(AutoDisposableHelper.DISPOSED);
        this.this$0.onError(throwable);
    }
}
