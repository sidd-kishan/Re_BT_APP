/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.work.impl.utils.SerialExecutor
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.concurrent.Executor;

public class WorkManagerTaskExecutor
implements TaskExecutor {
    private final SerialExecutor mBackgroundExecutor;
    private final Executor mMainThreadExecutor;
    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    public WorkManagerTaskExecutor(Executor executor) {
        this.mMainThreadExecutor = new /* Unavailable Anonymous Inner Class!! */;
        this.mBackgroundExecutor = new SerialExecutor(executor);
    }

    public void executeOnBackgroundThread(Runnable runnable) {
        this.mBackgroundExecutor.execute(runnable);
    }

    public SerialExecutor getBackgroundExecutor() {
        return this.mBackgroundExecutor;
    }

    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }

    public void postToMainThread(Runnable runnable) {
        this.mMainThreadHandler.post(runnable);
    }
}
