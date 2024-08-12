/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.executor.DefaultTaskExecutor
 *  androidx.arch.core.executor.TaskExecutor
 */
package androidx.arch.core.executor;

import androidx.arch.core.executor.DefaultTaskExecutor;
import androidx.arch.core.executor.TaskExecutor;
import java.util.concurrent.Executor;

public class ArchTaskExecutor
extends TaskExecutor {
    private static final Executor sIOThreadExecutor;
    private static volatile ArchTaskExecutor sInstance;
    private static final Executor sMainThreadExecutor;
    private TaskExecutor mDefaultTaskExecutor;
    private TaskExecutor mDelegate;

    static {
        sMainThreadExecutor = new /* Unavailable Anonymous Inner Class!! */;
        sIOThreadExecutor = new /* Unavailable Anonymous Inner Class!! */;
    }

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = defaultTaskExecutor;
        this.mDelegate = defaultTaskExecutor;
    }

    public static Executor getIOThreadExecutor() {
        return sIOThreadExecutor;
    }

    public static ArchTaskExecutor getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (ArchTaskExecutor.class) {
            ArchTaskExecutor archTaskExecutor;
            if (sInstance != null) return sInstance;
            sInstance = archTaskExecutor = new ArchTaskExecutor();
            return sInstance;
        }
    }

    public static Executor getMainThreadExecutor() {
        return sMainThreadExecutor;
    }

    public void executeOnDiskIO(Runnable runnable) {
        this.mDelegate.executeOnDiskIO(runnable);
    }

    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    public void postToMainThread(Runnable runnable) {
        this.mDelegate.postToMainThread(runnable);
    }

    public void setDelegate(TaskExecutor taskExecutor) {
        TaskExecutor taskExecutor2 = taskExecutor;
        if (taskExecutor == null) {
            taskExecutor2 = this.mDefaultTaskExecutor;
        }
        this.mDelegate = taskExecutor2;
    }
}
