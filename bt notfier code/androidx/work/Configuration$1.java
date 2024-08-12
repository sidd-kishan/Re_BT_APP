/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Configuration
 */
package androidx.work;

import androidx.work.Configuration;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class Configuration.1
implements ThreadFactory {
    private final AtomicInteger mThreadCount;
    final Configuration this$0;
    final boolean val$isTaskExecutor;

    Configuration.1(Configuration configuration, boolean bl) {
        this.this$0 = configuration;
        this.val$isTaskExecutor = bl;
        this.mThreadCount = new AtomicInteger(0);
    }

    @Override
    public Thread newThread(Runnable runnable) {
        String string = this.val$isTaskExecutor ? "WM.task-" : "androidx.work-";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(this.mThreadCount.incrementAndGet());
        return new Thread(runnable, stringBuilder.toString());
    }
}
