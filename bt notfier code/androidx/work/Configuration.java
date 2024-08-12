/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  androidx.work.Configuration$Builder
 *  androidx.work.InitializationExceptionHandler
 *  androidx.work.InputMergerFactory
 *  androidx.work.RunnableScheduler
 *  androidx.work.WorkerFactory
 *  androidx.work.impl.DefaultRunnableScheduler
 */
package androidx.work;

import android.os.Build;
import androidx.work.Configuration;
import androidx.work.InitializationExceptionHandler;
import androidx.work.InputMergerFactory;
import androidx.work.RunnableScheduler;
import androidx.work.WorkerFactory;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class Configuration {
    public static final int MIN_SCHEDULER_LIMIT = 20;
    final String mDefaultProcessName;
    final InitializationExceptionHandler mExceptionHandler;
    final Executor mExecutor;
    final InputMergerFactory mInputMergerFactory;
    private final boolean mIsUsingDefaultTaskExecutor;
    final int mLoggingLevel;
    final int mMaxJobSchedulerId;
    final int mMaxSchedulerLimit;
    final int mMinJobSchedulerId;
    final RunnableScheduler mRunnableScheduler;
    final Executor mTaskExecutor;
    final WorkerFactory mWorkerFactory;

    Configuration(Builder builder) {
        this.mExecutor = builder.mExecutor == null ? this.createDefaultExecutor(false) : builder.mExecutor;
        if (builder.mTaskExecutor == null) {
            this.mIsUsingDefaultTaskExecutor = true;
            this.mTaskExecutor = this.createDefaultExecutor(true);
        } else {
            this.mIsUsingDefaultTaskExecutor = false;
            this.mTaskExecutor = builder.mTaskExecutor;
        }
        this.mWorkerFactory = builder.mWorkerFactory == null ? WorkerFactory.getDefaultWorkerFactory() : builder.mWorkerFactory;
        this.mInputMergerFactory = builder.mInputMergerFactory == null ? InputMergerFactory.getDefaultInputMergerFactory() : builder.mInputMergerFactory;
        this.mRunnableScheduler = builder.mRunnableScheduler == null ? new DefaultRunnableScheduler() : builder.mRunnableScheduler;
        this.mLoggingLevel = builder.mLoggingLevel;
        this.mMinJobSchedulerId = builder.mMinJobSchedulerId;
        this.mMaxJobSchedulerId = builder.mMaxJobSchedulerId;
        this.mMaxSchedulerLimit = builder.mMaxSchedulerLimit;
        this.mExceptionHandler = builder.mExceptionHandler;
        this.mDefaultProcessName = builder.mDefaultProcessName;
    }

    private Executor createDefaultExecutor(boolean bl) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), this.createDefaultThreadFactory(bl));
    }

    private ThreadFactory createDefaultThreadFactory(boolean bl) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public String getDefaultProcessName() {
        return this.mDefaultProcessName;
    }

    public InitializationExceptionHandler getExceptionHandler() {
        return this.mExceptionHandler;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public InputMergerFactory getInputMergerFactory() {
        return this.mInputMergerFactory;
    }

    public int getMaxJobSchedulerId() {
        return this.mMaxJobSchedulerId;
    }

    public int getMaxSchedulerLimit() {
        if (Build.VERSION.SDK_INT != 23) return this.mMaxSchedulerLimit;
        return this.mMaxSchedulerLimit / 2;
    }

    public int getMinJobSchedulerId() {
        return this.mMinJobSchedulerId;
    }

    public int getMinimumLoggingLevel() {
        return this.mLoggingLevel;
    }

    public RunnableScheduler getRunnableScheduler() {
        return this.mRunnableScheduler;
    }

    public Executor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerFactory;
    }

    public boolean isUsingDefaultTaskExecutor() {
        return this.mIsUsingDefaultTaskExecutor;
    }
}
