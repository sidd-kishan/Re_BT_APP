/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.executor.IoExecutor
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.IoExecutor;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class IoExecutor.1
implements ThreadFactory {
    private static final String THREAD_NAME_STEM = "CameraX-camerax_io_%d";
    private final AtomicInteger mThreadId;
    final IoExecutor this$0;

    IoExecutor.1(IoExecutor ioExecutor) {
        this.this$0 = ioExecutor;
        this.mThreadId = new AtomicInteger(0);
    }

    @Override
    public Thread newThread(Runnable runnable) {
        runnable = new Thread(runnable);
        ((Thread)runnable).setName(String.format(Locale.US, THREAD_NAME_STEM, this.mThreadId.getAndIncrement()));
        return runnable;
    }
}
