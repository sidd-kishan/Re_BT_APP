/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.Data
 *  androidx.work.Logger
 *  androidx.work.ProgressUpdater
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.utils.futures.SettableFuture
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public class WorkProgressUpdater
implements ProgressUpdater {
    static final String TAG = Logger.tagWithPrefix((String)"WorkProgressUpdater");
    final TaskExecutor mTaskExecutor;
    final WorkDatabase mWorkDatabase;

    public WorkProgressUpdater(WorkDatabase workDatabase, TaskExecutor taskExecutor) {
        this.mWorkDatabase = workDatabase;
        this.mTaskExecutor = taskExecutor;
    }

    public ListenableFuture<Void> updateProgress(Context context, UUID uUID, Data data) {
        context = SettableFuture.create();
        this.mTaskExecutor.executeOnBackgroundThread((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        return context;
    }
}
