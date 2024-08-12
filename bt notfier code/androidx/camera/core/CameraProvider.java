/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.CameraInfoUnavailableException
 *  androidx.camera.core.CameraSelector
 */
package androidx.camera.core;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import java.util.List;

public interface CameraProvider {
    public List<CameraInfo> getAvailableCameraInfos();

    public boolean hasCamera(CameraSelector var1) throws CameraInfoUnavailableException;
}
