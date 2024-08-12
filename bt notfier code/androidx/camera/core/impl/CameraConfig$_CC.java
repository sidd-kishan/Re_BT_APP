/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraFilter
 *  androidx.camera.core.impl.CameraConfig
 *  androidx.camera.core.impl.CameraFilters
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraFilters;

public final class CameraConfig$_CC {
    public static CameraFilter $default$getCameraFilter(CameraConfig cameraConfig) {
        return (CameraFilter)cameraConfig.retrieveOption(CameraConfig.OPTION_CAMERA_FILTER, (Object)CameraFilters.ANY);
    }
}
