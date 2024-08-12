/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  com.uber.autodispose.OutsideScopeException
 *  com.uber.autodispose.android.DetachEventCompletable$Listener
 *  com.uber.autodispose.android.internal.AutoDisposeAndroidUtil
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.Disposable
 */
package com.uber.autodispose.android;

import android.os.Build;
import android.view.View;
import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.android.DetachEventCompletable;
import com.uber.autodispose.android.internal.AutoDisposeAndroidUtil;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;

final class DetachEventCompletable
implements CompletableSource {
    private final View view;

    DetachEventCompletable(View view) {
        this.view = view;
    }

    public void subscribe(CompletableObserver completableObserver) {
        Listener listener = new Listener(this.view, completableObserver);
        completableObserver.onSubscribe((Disposable)listener);
        if (!AutoDisposeAndroidUtil.isMainThread()) {
            completableObserver.onError((Throwable)new IllegalStateException("Views can only be bound to on the main thread!"));
            return;
        }
        boolean bl = Build.VERSION.SDK_INT >= 19 && this.view.isAttachedToWindow() || this.view.getWindowToken() != null;
        if (!bl) {
            completableObserver.onError((Throwable)new OutsideScopeException("View is not attached!"));
            return;
        }
        this.view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)listener);
        if (!listener.isDisposed()) return;
        this.view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)listener);
    }
}
