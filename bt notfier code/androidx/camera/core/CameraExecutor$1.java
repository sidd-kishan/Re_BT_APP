/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class CameraExecutor.1
implements ThreadFactory {
    private static final String THREAD_NAME_STEM = "CameraX-core_camera_%d";
    private final AtomicInteger mThreadId = new AtomicInteger(0);

    CameraExecutor.1() {
    }

    @Override
    public Thread newThread(Runnable runnable) {
        runnable = new Thread(runnable);
        ((Thread)runnable).setName(String.format(Locale.US, THREAD_NAME_STEM, this.mThreadId.getAndIncrement()));
        return runnable;
    }
}
