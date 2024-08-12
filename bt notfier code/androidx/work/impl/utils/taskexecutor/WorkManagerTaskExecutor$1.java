/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor
 */
package androidx.work.impl.utils.taskexecutor;

import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.concurrent.Executor;

class WorkManagerTaskExecutor.1
implements Executor {
    final WorkManagerTaskExecutor this$0;

    WorkManagerTaskExecutor.1(WorkManagerTaskExecutor workManagerTaskExecutor) {
        this.this$0 = workManagerTaskExecutor;
    }

    @Override
    public void execute(Runnable runnable) {
        this.this$0.postToMainThread(runnable);
    }
}
