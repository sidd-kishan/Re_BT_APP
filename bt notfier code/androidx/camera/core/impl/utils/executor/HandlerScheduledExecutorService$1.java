/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService
 */
package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import java.util.concurrent.ScheduledExecutorService;

class HandlerScheduledExecutorService.1
extends ThreadLocal<ScheduledExecutorService> {
    HandlerScheduledExecutorService.1() {
    }

    @Override
    public ScheduledExecutorService initialValue() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return CameraXExecutors.mainThreadExecutor();
        }
        if (Looper.myLooper() == null) return null;
        return new HandlerScheduledExecutorService(new Handler(Looper.myLooper()));
    }
}
