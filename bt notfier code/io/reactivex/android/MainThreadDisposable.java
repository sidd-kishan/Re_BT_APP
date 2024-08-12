/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  io.reactivex.android.schedulers.AndroidSchedulers
 *  io.reactivex.disposables.Disposable
 */
package io.reactivex.android;

import android.os.Looper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MainThreadDisposable
implements Disposable {
    private final AtomicBoolean unsubscribed = new AtomicBoolean();

    public static void verifyMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected to be called on the main thread but was ");
        stringBuilder.append(Thread.currentThread().getName());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final void dispose() {
        if (!this.unsubscribed.compareAndSet(false, true)) return;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.onDispose();
        } else {
            AndroidSchedulers.mainThread().scheduleDirect((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    public final boolean isDisposed() {
        return this.unsubscribed.get();
    }

    protected abstract void onDispose();
}
