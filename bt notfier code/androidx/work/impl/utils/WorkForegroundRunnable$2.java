/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.ForegroundInfo
 *  androidx.work.Logger
 *  androidx.work.impl.utils.WorkForegroundRunnable
 *  androidx.work.impl.utils.futures.SettableFuture
 */
package androidx.work.impl.utils;

import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.futures.SettableFuture;

class WorkForegroundRunnable.2
implements Runnable {
    final WorkForegroundRunnable this$0;
    final SettableFuture val$foregroundFuture;

    WorkForegroundRunnable.2(WorkForegroundRunnable workForegroundRunnable, SettableFuture settableFuture) {
        this.this$0 = workForegroundRunnable;
        this.val$foregroundFuture = settableFuture;
    }

    @Override
    public void run() {
        try {
            Object object = (ForegroundInfo)this.val$foregroundFuture.get();
            if (object == null) {
                String string = String.format("Worker was marked important (%s) but did not provide ForegroundInfo", this.this$0.mWorkSpec.workerClassName);
                object = new IllegalStateException(string);
                throw object;
            }
            Logger.get().debug(WorkForegroundRunnable.TAG, String.format("Updating notification for %s", this.this$0.mWorkSpec.workerClassName), new Throwable[0]);
            this.this$0.mWorker.setRunInForeground(true);
            this.this$0.mFuture.setFuture(this.this$0.mForegroundUpdater.setForegroundAsync(this.this$0.mContext, this.this$0.mWorker.getId(), object));
        }
        catch (Throwable throwable) {
            this.this$0.mFuture.setException(throwable);
        }
    }
}
