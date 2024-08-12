/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Network
 *  android.net.Uri
 *  androidx.work.Data
 *  androidx.work.ForegroundUpdater
 *  androidx.work.ProgressUpdater
 *  androidx.work.WorkerFactory
 *  androidx.work.WorkerParameters$RuntimeExtras
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.work.Data;
import androidx.work.ForegroundUpdater;
import androidx.work.ProgressUpdater;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {
    private Executor mBackgroundExecutor;
    private ForegroundUpdater mForegroundUpdater;
    private UUID mId;
    private Data mInputData;
    private ProgressUpdater mProgressUpdater;
    private int mRunAttemptCount;
    private RuntimeExtras mRuntimeExtras;
    private Set<String> mTags;
    private TaskExecutor mWorkTaskExecutor;
    private WorkerFactory mWorkerFactory;

    public WorkerParameters(UUID uUID, Data data, Collection<String> collection, RuntimeExtras runtimeExtras, int n, Executor executor, TaskExecutor taskExecutor, WorkerFactory workerFactory, ProgressUpdater progressUpdater, ForegroundUpdater foregroundUpdater) {
        this.mId = uUID;
        this.mInputData = data;
        this.mTags = new HashSet<String>(collection);
        this.mRuntimeExtras = runtimeExtras;
        this.mRunAttemptCount = n;
        this.mBackgroundExecutor = executor;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkerFactory = workerFactory;
        this.mProgressUpdater = progressUpdater;
        this.mForegroundUpdater = foregroundUpdater;
    }

    public Executor getBackgroundExecutor() {
        return this.mBackgroundExecutor;
    }

    public ForegroundUpdater getForegroundUpdater() {
        return this.mForegroundUpdater;
    }

    public UUID getId() {
        return this.mId;
    }

    public Data getInputData() {
        return this.mInputData;
    }

    public Network getNetwork() {
        return this.mRuntimeExtras.network;
    }

    public ProgressUpdater getProgressUpdater() {
        return this.mProgressUpdater;
    }

    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    public RuntimeExtras getRuntimeExtras() {
        return this.mRuntimeExtras;
    }

    public Set<String> getTags() {
        return this.mTags;
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    public List<String> getTriggeredContentAuthorities() {
        return this.mRuntimeExtras.triggeredContentAuthorities;
    }

    public List<Uri> getTriggeredContentUris() {
        return this.mRuntimeExtras.triggeredContentUris;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerFactory;
    }
}
