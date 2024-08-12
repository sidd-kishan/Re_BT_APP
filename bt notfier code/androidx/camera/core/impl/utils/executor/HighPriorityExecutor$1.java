/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.executor.HighPriorityExecutor
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.HighPriorityExecutor;
import java.util.concurrent.ThreadFactory;

class HighPriorityExecutor.1
implements ThreadFactory {
    private static final String THREAD_NAME = "CameraX-camerax_high_priority";
    final HighPriorityExecutor this$0;

    HighPriorityExecutor.1(HighPriorityExecutor highPriorityExecutor) {
        this.this$0 = highPriorityExecutor;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        runnable = new Thread(runnable);
        ((Thread)runnable).setPriority(10);
        ((Thread)runnable).setName(THREAD_NAME);
        return runnable;
    }
}
