/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.WorkForegroundRunnable
 *  androidx.work.impl.utils.futures.SettableFuture
 */
package androidx.work.impl.utils;

import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.futures.SettableFuture;

class WorkForegroundRunnable.1
implements Runnable {
    final WorkForegroundRunnable this$0;
    final SettableFuture val$foregroundFuture;

    WorkForegroundRunnable.1(WorkForegroundRunnable workForegroundRunnable, SettableFuture settableFuture) {
        this.this$0 = workForegroundRunnable;
        this.val$foregroundFuture = settableFuture;
    }

    @Override
    public void run() {
        this.val$foregroundFuture.setFuture(this.this$0.mWorker.getForegroundInfoAsync());
    }
}
