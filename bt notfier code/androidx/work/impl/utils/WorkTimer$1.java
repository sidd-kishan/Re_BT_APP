/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.WorkTimer
 */
package androidx.work.impl.utils;

import androidx.work.impl.utils.WorkTimer;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class WorkTimer.1
implements ThreadFactory {
    private int mThreadsCreated;
    final WorkTimer this$0;

    WorkTimer.1(WorkTimer workTimer) {
        this.this$0 = workTimer;
        this.mThreadsCreated = 0;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        runnable = Executors.defaultThreadFactory().newThread(runnable);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WorkManager-WorkTimer-thread-");
        stringBuilder.append(this.mThreadsCreated);
        ((Thread)runnable).setName(stringBuilder.toString());
        ++this.mThreadsCreated;
        return runnable;
    }
}
