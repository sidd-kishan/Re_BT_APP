/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.camera.core.impl.CameraThreadConfig
 */
package androidx.camera.core.impl;

import android.os.Handler;
import androidx.camera.core.impl.CameraThreadConfig;
import java.util.concurrent.Executor;

final class AutoValue_CameraThreadConfig
extends CameraThreadConfig {
    private final Executor cameraExecutor;
    private final Handler schedulerHandler;

    AutoValue_CameraThreadConfig(Executor executor, Handler handler) {
        if (executor == null) throw new NullPointerException("Null cameraExecutor");
        this.cameraExecutor = executor;
        if (handler == null) throw new NullPointerException("Null schedulerHandler");
        this.schedulerHandler = handler;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof CameraThreadConfig)) return false;
        if (this.cameraExecutor.equals((object = (CameraThreadConfig)object).getCameraExecutor()) && this.schedulerHandler.equals(object.getSchedulerHandler())) return bl;
        bl = false;
        return bl;
    }

    public Executor getCameraExecutor() {
        return this.cameraExecutor;
    }

    public Handler getSchedulerHandler() {
        return this.schedulerHandler;
    }

    public int hashCode() {
        return (this.cameraExecutor.hashCode() ^ 0xF4243) * 1000003 ^ this.schedulerHandler.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CameraThreadConfig{cameraExecutor=");
        stringBuilder.append(this.cameraExecutor);
        stringBuilder.append(", schedulerHandler=");
        stringBuilder.append(this.schedulerHandler);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
