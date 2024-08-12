/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.SerialExecutor
 */
package androidx.work.impl.utils.taskexecutor;

import androidx.work.impl.utils.SerialExecutor;
import java.util.concurrent.Executor;

public interface TaskExecutor {
    public void executeOnBackgroundThread(Runnable var1);

    public SerialExecutor getBackgroundExecutor();

    public Executor getMainThreadExecutor();

    public void postToMainThread(Runnable var1);
}
