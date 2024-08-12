/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.work.ForegroundInfo
 *  androidx.work.impl.foreground.SystemForegroundDispatcher
 *  androidx.work.impl.utils.WorkForegroundUpdater
 *  androidx.work.impl.utils.futures.SettableFuture
 */
package androidx.work.impl.utils;

import android.content.Context;
import android.content.Intent;
import androidx.work.ForegroundInfo;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.UUID;

class WorkForegroundUpdater.1
implements Runnable {
    final WorkForegroundUpdater this$0;
    final Context val$context;
    final ForegroundInfo val$foregroundInfo;
    final SettableFuture val$future;
    final UUID val$id;

    WorkForegroundUpdater.1(WorkForegroundUpdater workForegroundUpdater, SettableFuture settableFuture, UUID uUID, ForegroundInfo foregroundInfo, Context context) {
        this.this$0 = workForegroundUpdater;
        this.val$future = settableFuture;
        this.val$id = uUID;
        this.val$foregroundInfo = foregroundInfo;
        this.val$context = context;
    }

    @Override
    public void run() {
        try {
            if (!this.val$future.isCancelled()) {
                String string = this.val$id.toString();
                Object object = this.this$0.mWorkSpecDao.getState(string);
                if (object != null && !object.isFinished()) {
                    this.this$0.mForegroundProcessor.startForeground(string, this.val$foregroundInfo);
                    object = SystemForegroundDispatcher.createNotifyIntent((Context)this.val$context, (String)string, (ForegroundInfo)this.val$foregroundInfo);
                    this.val$context.startService((Intent)object);
                } else {
                    object = new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    throw object;
                }
            }
            this.val$future.set(null);
        }
        catch (Throwable throwable) {
            this.val$future.setException(throwable);
        }
    }
}
