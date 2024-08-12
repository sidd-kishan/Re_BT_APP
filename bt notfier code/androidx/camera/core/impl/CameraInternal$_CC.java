/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraControl
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.impl.CameraConfig
 *  androidx.camera.core.impl.CameraConfigs
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.internal.CameraUseCaseAdapter$CameraException
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import java.util.Collections;
import java.util.LinkedHashSet;

public final class CameraInternal$_CC {
    public static CameraControl $default$getCameraControl(CameraInternal cameraInternal) {
        return cameraInternal.getCameraControlInternal();
    }

    public static CameraInfo $default$getCameraInfo(CameraInternal cameraInternal) {
        return cameraInternal.getCameraInfoInternal();
    }

    public static LinkedHashSet<CameraInternal> $default$getCameraInternals(CameraInternal cameraInternal) {
        return new LinkedHashSet<CameraInternal>(Collections.singleton(cameraInternal));
    }

    public static CameraConfig $default$getExtendedConfig(CameraInternal cameraInternal) {
        return CameraConfigs.emptyConfig();
    }

    public static void $default$setExtendedConfig(CameraInternal cameraInternal, CameraConfig cameraConfig) throws CameraUseCaseAdapter.CameraException {
    }
}
