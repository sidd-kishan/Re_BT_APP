/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

private static class AsyncListDiffer.MainThreadExecutor
implements Executor {
    final Handler mHandler = new Handler(Looper.getMainLooper());

    AsyncListDiffer.MainThreadExecutor() {
    }

    @Override
    public void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }
}
