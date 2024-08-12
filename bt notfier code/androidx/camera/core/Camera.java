/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraControl
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.impl.CameraConfig
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.internal.CameraUseCaseAdapter$CameraException
 */
package androidx.camera.core;

import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import java.util.LinkedHashSet;

public interface Camera {
    public CameraControl getCameraControl();

    public CameraInfo getCameraInfo();

    public LinkedHashSet<CameraInternal> getCameraInternals();

    public CameraConfig getExtendedConfig();

    public void setExtendedConfig(CameraConfig var1) throws CameraUseCaseAdapter.CameraException;
}
