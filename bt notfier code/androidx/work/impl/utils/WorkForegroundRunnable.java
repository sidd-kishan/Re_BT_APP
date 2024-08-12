/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.core.os.BuildCompat
 *  androidx.work.ForegroundUpdater
 *  androidx.work.ListenableWorker
 *  androidx.work.Logger
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.futures.SettableFuture
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.utils;

import android.content.Context;
import androidx.core.os.BuildCompat;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;

public class WorkForegroundRunnable
implements Runnable {
    static final String TAG = Logger.tagWithPrefix((String)"WorkForegroundRunnable");
    final Context mContext;
    final ForegroundUpdater mForegroundUpdater;
    final SettableFuture<Void> mFuture = SettableFuture.create();
    final TaskExecutor mTaskExecutor;
    final WorkSpec mWorkSpec;
    final ListenableWorker mWorker;

    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor) {
        this.mContext = context;
        this.mWorkSpec = workSpec;
        this.mWorker = listenableWorker;
        this.mForegroundUpdater = foregroundUpdater;
        this.mTaskExecutor = taskExecutor;
    }

    public ListenableFuture<Void> getFuture() {
        return this.mFuture;
    }

    @Override
    public void run() {
        if (this.mWorkSpec.expedited && !BuildCompat.isAtLeastS()) {
            SettableFuture settableFuture = SettableFuture.create();
            this.mTaskExecutor.getMainThreadExecutor().execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            settableFuture.addListener((Runnable)new /* Unavailable Anonymous Inner Class!! */, this.mTaskExecutor.getMainThreadExecutor());
            return;
        }
        this.mFuture.set(null);
    }
}
