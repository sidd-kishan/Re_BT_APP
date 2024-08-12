/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class HighPriorityExecutor
implements Executor {
    private static volatile Executor sExecutor;
    private final ExecutorService mHighPriorityService = Executors.newSingleThreadExecutor((ThreadFactory)new /* Unavailable Anonymous Inner Class!! */);

    HighPriorityExecutor() {
    }

    static Executor getInstance() {
        if (sExecutor != null) {
            return sExecutor;
        }
        synchronized (HighPriorityExecutor.class) {
            if (sExecutor != null) return sExecutor;
            HighPriorityExecutor highPriorityExecutor = new HighPriorityExecutor();
            sExecutor = highPriorityExecutor;
            return sExecutor;
        }
    }

    @Override
    public void execute(Runnable runnable) {
        this.mHighPriorityService.execute(runnable);
    }
}
