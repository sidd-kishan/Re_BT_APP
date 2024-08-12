/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraConfig
 *  androidx.camera.core.impl.CameraConfigs$EmptyCameraConfig
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;

public class CameraConfigs {
    private static final CameraConfig EMPTY_CONFIG = new EmptyCameraConfig();

    private CameraConfigs() {
    }

    public static CameraConfig emptyConfig() {
        return EMPTY_CONFIG;
    }
}
