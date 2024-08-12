/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraConfigs$EmptyCameraConfig
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.UseCaseConfigFactory
 *  androidx.camera.core.impl.UseCaseConfigFactory$CaptureType
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.UseCaseConfigFactory;

class CameraConfigs.EmptyCameraConfig.1
implements UseCaseConfigFactory {
    final CameraConfigs.EmptyCameraConfig this$0;

    CameraConfigs.EmptyCameraConfig.1(CameraConfigs.EmptyCameraConfig emptyCameraConfig) {
        this.this$0 = emptyCameraConfig;
    }

    public Config getConfig(UseCaseConfigFactory.CaptureType captureType) {
        return null;
    }
}
