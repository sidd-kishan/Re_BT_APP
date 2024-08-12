/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.core.os.HandlerCompat
 *  androidx.work.RunnableScheduler
 */
package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;

public class DefaultRunnableScheduler
implements RunnableScheduler {
    private final Handler mHandler;

    public DefaultRunnableScheduler() {
        this.mHandler = HandlerCompat.createAsync((Looper)Looper.getMainLooper());
    }

    public DefaultRunnableScheduler(Handler handler) {
        this.mHandler = handler;
    }

    public void cancel(Runnable runnable) {
        this.mHandler.removeCallbacks(runnable);
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void scheduleWithDelay(long l, Runnable runnable) {
        this.mHandler.postDelayed(runnable, l);
    }
}
