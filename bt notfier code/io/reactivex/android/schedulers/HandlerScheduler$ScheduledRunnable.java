/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.android.schedulers;

import android.os.Handler;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;

private static final class HandlerScheduler.ScheduledRunnable
implements Runnable,
Disposable {
    private final Runnable delegate;
    private volatile boolean disposed;
    private final Handler handler;

    HandlerScheduler.ScheduledRunnable(Handler handler, Runnable runnable) {
        this.handler = handler;
        this.delegate = runnable;
    }

    public void dispose() {
        this.handler.removeCallbacks((Runnable)this);
        this.disposed = true;
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    @Override
    public void run() {
        try {
            this.delegate.run();
        }
        catch (Throwable throwable) {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }
}
