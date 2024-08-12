/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Data
 *  androidx.work.Logger
 *  androidx.work.WorkInfo$State
 *  androidx.work.impl.model.WorkProgress
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.WorkProgressUpdater
 *  androidx.work.impl.utils.futures.SettableFuture
 */
package androidx.work.impl.utils;

import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.UUID;

class WorkProgressUpdater.1
implements Runnable {
    final WorkProgressUpdater this$0;
    final Data val$data;
    final SettableFuture val$future;
    final UUID val$id;

    WorkProgressUpdater.1(WorkProgressUpdater workProgressUpdater, UUID uUID, Data data, SettableFuture settableFuture) {
        this.this$0 = workProgressUpdater;
        this.val$id = uUID;
        this.val$data = data;
        this.val$future = settableFuture;
    }

    @Override
    public void run() {
        Object object = this.val$id.toString();
        Logger.get().debug(WorkProgressUpdater.TAG, String.format("Updating progress for %s (%s)", this.val$id, this.val$data), new Throwable[0]);
        this.this$0.mWorkDatabase.beginTransaction();
        try {
            WorkSpec workSpec = this.this$0.mWorkDatabase.workSpecDao().getWorkSpec((String)object);
            if (workSpec == null) {
                object = new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                throw object;
            }
            if (workSpec.state == WorkInfo.State.RUNNING) {
                workSpec = new WorkProgress((String)object, this.val$data);
                this.this$0.mWorkDatabase.workProgressDao().insert((WorkProgress)workSpec);
            } else {
                Logger.get().warning(WorkProgressUpdater.TAG, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", object), new Throwable[0]);
            }
            this.val$future.set(null);
            this.this$0.mWorkDatabase.setTransactionSuccessful();
        }
        catch (Throwable throwable) {
            try {
                Logger.get().error(WorkProgressUpdater.TAG, "Error updating Worker progress", new Throwable[]{throwable});
                this.val$future.setException(throwable);
            }
            finally {
                this.this$0.mWorkDatabase.endTransaction();
            }
        }
    }
}
