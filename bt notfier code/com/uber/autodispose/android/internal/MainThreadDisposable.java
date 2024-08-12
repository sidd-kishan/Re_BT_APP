/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.android.internal.AutoDisposeAndroidUtil
 *  com.uber.autodispose.android.internal._$$Lambda$pq2v3zuHA6BURGVoG6CvPmpdahY
 *  io.reactivex.android.schedulers.AndroidSchedulers
 *  io.reactivex.disposables.Disposable
 */
package com.uber.autodispose.android.internal;

import com.uber.autodispose.android.internal.AutoDisposeAndroidUtil;
import com.uber.autodispose.android.internal._$;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MainThreadDisposable
implements Disposable {
    private final AtomicBoolean unsubscribed = new AtomicBoolean();

    public final void dispose() {
        if (!this.unsubscribed.compareAndSet(false, true)) return;
        if (AutoDisposeAndroidUtil.isMainThread()) {
            this.onDispose();
        } else {
            AndroidSchedulers.mainThread().scheduleDirect((Runnable)new _$.Lambda.pq2v3zuHA6BURGVoG6CvPmpdahY(this));
        }
    }

    public final boolean isDisposed() {
        return this.unsubscribed.get();
    }

    protected abstract void onDispose();
}
