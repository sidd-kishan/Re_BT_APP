/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraFactory
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import androidx.camera.core.impl.CameraFactory;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class CameraExecutor
implements Executor {
    private static final int DEFAULT_CORE_THREADS = 1;
    private static final int DEFAULT_MAX_THREADS = 1;
    private static final ThreadFactory THREAD_FACTORY = new /* Unavailable Anonymous Inner Class!! */;
    private final Object mExecutorLock = new Object();
    private ThreadPoolExecutor mThreadPoolExecutor = CameraExecutor.createExecutor();

    CameraExecutor() {
    }

    private static ThreadPoolExecutor createExecutor() {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), THREAD_FACTORY);
    }

    void deinit() {
        Object object = this.mExecutorLock;
        synchronized (object) {
            if (this.mThreadPoolExecutor.isShutdown()) return;
            this.mThreadPoolExecutor.shutdown();
            return;
        }
    }

    @Override
    public void execute(Runnable runnable) {
        Preconditions.checkNotNull((Object)runnable);
        Object object = this.mExecutorLock;
        synchronized (object) {
            this.mThreadPoolExecutor.execute(runnable);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void init(CameraFactory cameraFactory) {
        ThreadPoolExecutor threadPoolExecutor;
        Preconditions.checkNotNull((Object)cameraFactory);
        Object object = this.mExecutorLock;
        synchronized (object) {
            if (this.mThreadPoolExecutor.isShutdown()) {
                this.mThreadPoolExecutor = CameraExecutor.createExecutor();
            }
            threadPoolExecutor = this.mThreadPoolExecutor;
        }
        int n = Math.max(1, cameraFactory.getAvailableCameraIds().size());
        threadPoolExecutor.setMaximumPoolSize(n);
        threadPoolExecutor.setCorePoolSize(n);
    }
}
