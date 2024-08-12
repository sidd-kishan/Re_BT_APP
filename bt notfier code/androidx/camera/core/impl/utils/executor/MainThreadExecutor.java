/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService
 */
package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import java.util.concurrent.ScheduledExecutorService;

final class MainThreadExecutor {
    private static volatile ScheduledExecutorService sInstance;

    private MainThreadExecutor() {
    }

    static ScheduledExecutorService getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (MainThreadExecutor.class) {
            if (sInstance != null) return sInstance;
            Handler handler = new Handler(Looper.getMainLooper());
            HandlerScheduledExecutorService handlerScheduledExecutorService = new HandlerScheduledExecutorService(handler);
            sInstance = handlerScheduledExecutorService;
            return sInstance;
        }
    }
}
