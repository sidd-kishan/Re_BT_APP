/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.Configuration
 *  androidx.work.ListenableWorker
 *  androidx.work.WorkerParameters$RuntimeExtras
 *  androidx.work.impl.Scheduler
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkerWrapper
 *  androidx.work.impl.foreground.ForegroundProcessor
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.List;

public static class WorkerWrapper.Builder {
    Context mAppContext;
    Configuration mConfiguration;
    ForegroundProcessor mForegroundProcessor;
    WorkerParameters.RuntimeExtras mRuntimeExtras = new WorkerParameters.RuntimeExtras();
    List<Scheduler> mSchedulers;
    WorkDatabase mWorkDatabase;
    String mWorkSpecId;
    TaskExecutor mWorkTaskExecutor;
    ListenableWorker mWorker;

    public WorkerWrapper.Builder(Context context, Configuration configuration, TaskExecutor taskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase workDatabase, String string) {
        this.mAppContext = context.getApplicationContext();
        this.mWorkTaskExecutor = taskExecutor;
        this.mForegroundProcessor = foregroundProcessor;
        this.mConfiguration = configuration;
        this.mWorkDatabase = workDatabase;
        this.mWorkSpecId = string;
    }

    public WorkerWrapper build() {
        return new WorkerWrapper(this);
    }

    public WorkerWrapper.Builder withRuntimeExtras(WorkerParameters.RuntimeExtras runtimeExtras) {
        if (runtimeExtras == null) return this;
        this.mRuntimeExtras = runtimeExtras;
        return this;
    }

    public WorkerWrapper.Builder withSchedulers(List<Scheduler> list) {
        this.mSchedulers = list;
        return this;
    }

    public WorkerWrapper.Builder withWorker(ListenableWorker listenableWorker) {
        this.mWorker = listenableWorker;
        return this;
    }
}
