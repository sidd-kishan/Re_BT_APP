/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraX
 *  androidx.camera.core.CameraXConfig
 *  androidx.camera.core.CameraXConfig$Provider
 */
package androidx.camera.core;

import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;

public final class _$$Lambda$CameraX$wMZjJsgpnlorhgxL81349SKdSDE
implements CameraXConfig.Provider {
    private final CameraXConfig f$0;

    public /* synthetic */ _$$Lambda$CameraX$wMZjJsgpnlorhgxL81349SKdSDE(CameraXConfig cameraXConfig) {
        this.f$0 = cameraXConfig;
    }

    public final CameraXConfig getCameraXConfig() {
        return CameraX.lambda$configureInstance$1((CameraXConfig)this.f$0);
    }
}