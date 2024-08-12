/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Network
 *  android.net.Uri
 *  androidx.work.Data
 *  androidx.work.ForegroundInfo
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.WorkerFactory
 *  androidx.work.WorkerParameters
 *  androidx.work.impl.utils.futures.SettableFuture
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.work.Data;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker {
    private Context mAppContext;
    private boolean mRunInForeground;
    private volatile boolean mStopped;
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) throw new IllegalArgumentException("Application Context is null");
        if (workerParameters == null) throw new IllegalArgumentException("WorkerParameters is null");
        this.mAppContext = context;
        this.mWorkerParams = workerParameters;
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.getBackgroundExecutor();
    }

    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        SettableFuture settableFuture = SettableFuture.create();
        settableFuture.setException((Throwable)new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return settableFuture;
    }

    public final UUID getId() {
        return this.mWorkerParams.getId();
    }

    public final Data getInputData() {
        return this.mWorkerParams.getInputData();
    }

    public final Network getNetwork() {
        return this.mWorkerParams.getNetwork();
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.getRunAttemptCount();
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.getTags();
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkerParams.getTaskExecutor();
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.getTriggeredContentAuthorities();
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.getTriggeredContentUris();
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerParams.getWorkerFactory();
    }

    public boolean isRunInForeground() {
        return this.mRunInForeground;
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public void onStopped() {
    }

    public final ListenableFuture<Void> setForegroundAsync(ForegroundInfo foregroundInfo) {
        this.mRunInForeground = true;
        return this.mWorkerParams.getForegroundUpdater().setForegroundAsync(this.getApplicationContext(), this.getId(), foregroundInfo);
    }

    public ListenableFuture<Void> setProgressAsync(Data data) {
        return this.mWorkerParams.getProgressUpdater().updateProgress(this.getApplicationContext(), this.getId(), data);
    }

    public void setRunInForeground(boolean bl) {
        this.mRunInForeground = bl;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract ListenableFuture<Result> startWork();

    public final void stop() {
        this.mStopped = true;
        this.onStopped();
    }
}
