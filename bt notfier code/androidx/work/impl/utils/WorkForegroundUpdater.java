/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.ForegroundInfo
 *  androidx.work.ForegroundUpdater
 *  androidx.work.Logger
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.foreground.ForegroundProcessor
 *  androidx.work.impl.model.WorkSpecDao
 *  androidx.work.impl.utils.futures.SettableFuture
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public class WorkForegroundUpdater
implements ForegroundUpdater {
    private static final String TAG = Logger.tagWithPrefix((String)"WMFgUpdater");
    final ForegroundProcessor mForegroundProcessor;
    private final TaskExecutor mTaskExecutor;
    final WorkSpecDao mWorkSpecDao;

    public WorkForegroundUpdater(WorkDatabase workDatabase, ForegroundProcessor foregroundProcessor, TaskExecutor taskExecutor) {
        this.mForegroundProcessor = foregroundProcessor;
        this.mTaskExecutor = taskExecutor;
        this.mWorkSpecDao = workDatabase.workSpecDao();
    }

    public ListenableFuture<Void> setForegroundAsync(Context context, UUID uUID, ForegroundInfo foregroundInfo) {
        SettableFuture settableFuture = SettableFuture.create();
        this.mTaskExecutor.executeOnBackgroundThread((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        return settableFuture;
    }
}
