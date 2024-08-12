/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.executor.DefaultTaskExecutor
 */
package androidx.arch.core.executor;

import androidx.arch.core.executor.DefaultTaskExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class DefaultTaskExecutor.1
implements ThreadFactory {
    private static final String THREAD_NAME_STEM = "arch_disk_io_%d";
    private final AtomicInteger mThreadId;
    final DefaultTaskExecutor this$0;

    DefaultTaskExecutor.1(DefaultTaskExecutor defaultTaskExecutor) {
        this.this$0 = defaultTaskExecutor;
        this.mThreadId = new AtomicInteger(0);
    }

    @Override
    public Thread newThread(Runnable runnable) {
        runnable = new Thread(runnable);
        ((Thread)runnable).setName(String.format(THREAD_NAME_STEM, this.mThreadId.getAndIncrement()));
        return runnable;
    }
}
