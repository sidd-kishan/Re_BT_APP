/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class IoExecutor
implements Executor {
    private static volatile Executor sExecutor;
    private final ExecutorService mIoService = Executors.newFixedThreadPool(2, (ThreadFactory)new /* Unavailable Anonymous Inner Class!! */);

    IoExecutor() {
    }

    static Executor getInstance() {
        if (sExecutor != null) {
            return sExecutor;
        }
        synchronized (IoExecutor.class) {
            if (sExecutor != null) return sExecutor;
            IoExecutor ioExecutor = new IoExecutor();
            sExecutor = ioExecutor;
            return sExecutor;
        }
    }

    @Override
    public void execute(Runnable runnable) {
        this.mIoService.execute(runnable);
    }
}
