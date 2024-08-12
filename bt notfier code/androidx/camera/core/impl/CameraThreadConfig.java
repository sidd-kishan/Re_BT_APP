/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.camera.core.impl.AutoValue_CameraThreadConfig
 */
package androidx.camera.core.impl;

import android.os.Handler;
import androidx.camera.core.impl.AutoValue_CameraThreadConfig;
import java.util.concurrent.Executor;

public abstract class CameraThreadConfig {
    public static CameraThreadConfig create(Executor executor, Handler handler) {
        return new AutoValue_CameraThreadConfig(executor, handler);
    }

    public abstract Executor getCameraExecutor();

    public abstract Handler getSchedulerHandler();
}
