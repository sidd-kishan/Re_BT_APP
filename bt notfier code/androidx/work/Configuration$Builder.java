/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Configuration
 *  androidx.work.InitializationExceptionHandler
 *  androidx.work.InputMergerFactory
 *  androidx.work.RunnableScheduler
 *  androidx.work.WorkerFactory
 */
package androidx.work;

import androidx.work.Configuration;
import androidx.work.InitializationExceptionHandler;
import androidx.work.InputMergerFactory;
import androidx.work.RunnableScheduler;
import androidx.work.WorkerFactory;
import java.util.concurrent.Executor;

public static final class Configuration.Builder {
    String mDefaultProcessName;
    InitializationExceptionHandler mExceptionHandler;
    Executor mExecutor;
    InputMergerFactory mInputMergerFactory;
    int mLoggingLevel;
    int mMaxJobSchedulerId;
    int mMaxSchedulerLimit;
    int mMinJobSchedulerId;
    RunnableScheduler mRunnableScheduler;
    Executor mTaskExecutor;
    WorkerFactory mWorkerFactory;

    public Configuration.Builder() {
        this.mLoggingLevel = 4;
        this.mMinJobSchedulerId = 0;
        this.mMaxJobSchedulerId = Integer.MAX_VALUE;
        this.mMaxSchedulerLimit = 20;
    }

    public Configuration.Builder(Configuration configuration) {
        this.mExecutor = configuration.mExecutor;
        this.mWorkerFactory = configuration.mWorkerFactory;
        this.mInputMergerFactory = configuration.mInputMergerFactory;
        this.mTaskExecutor = configuration.mTaskExecutor;
        this.mLoggingLevel = configuration.mLoggingLevel;
        this.mMinJobSchedulerId = configuration.mMinJobSchedulerId;
        this.mMaxJobSchedulerId = configuration.mMaxJobSchedulerId;
        this.mMaxSchedulerLimit = configuration.mMaxSchedulerLimit;
        this.mRunnableScheduler = configuration.mRunnableScheduler;
        this.mExceptionHandler = configuration.mExceptionHandler;
        this.mDefaultProcessName = configuration.mDefaultProcessName;
    }

    public Configuration build() {
        return new Configuration(this);
    }

    public Configuration.Builder setDefaultProcessName(String string) {
        this.mDefaultProcessName = string;
        return this;
    }

    public Configuration.Builder setExecutor(Executor executor) {
        this.mExecutor = executor;
        return this;
    }

    public Configuration.Builder setInitializationExceptionHandler(InitializationExceptionHandler initializationExceptionHandler) {
        this.mExceptionHandler = initializationExceptionHandler;
        return this;
    }

    public Configuration.Builder setInputMergerFactory(InputMergerFactory inputMergerFactory) {
        this.mInputMergerFactory = inputMergerFactory;
        return this;
    }

    public Configuration.Builder setJobSchedulerJobIdRange(int n, int n2) {
        if (n2 - n < 1000) throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
        this.mMinJobSchedulerId = n;
        this.mMaxJobSchedulerId = n2;
        return this;
    }

    public Configuration.Builder setMaxSchedulerLimit(int n) {
        if (n < 20) throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
        this.mMaxSchedulerLimit = Math.min(n, 50);
        return this;
    }

    public Configuration.Builder setMinimumLoggingLevel(int n) {
        this.mLoggingLevel = n;
        return this;
    }

    public Configuration.Builder setRunnableScheduler(RunnableScheduler runnableScheduler) {
        this.mRunnableScheduler = runnableScheduler;
        return this;
    }

    public Configuration.Builder setTaskExecutor(Executor executor) {
        this.mTaskExecutor = executor;
        return this;
    }

    public Configuration.Builder setWorkerFactory(WorkerFactory workerFactory) {
        this.mWorkerFactory = workerFactory;
        return this;
    }
}
