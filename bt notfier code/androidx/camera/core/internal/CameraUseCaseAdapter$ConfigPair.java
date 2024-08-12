/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.UseCaseConfig
 */
package androidx.camera.core.internal;

import androidx.camera.core.impl.UseCaseConfig;

private static class CameraUseCaseAdapter.ConfigPair {
    UseCaseConfig<?> mCameraConfig;
    UseCaseConfig<?> mExtendedConfig;

    CameraUseCaseAdapter.ConfigPair(UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
        this.mExtendedConfig = useCaseConfig;
        this.mCameraConfig = useCaseConfig2;
    }
}
