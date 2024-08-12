/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture$Builder
 *  androidx.camera.core.impl.ConfigProvider
 *  androidx.camera.core.impl.ImageCaptureConfig
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageCaptureConfig;

public static final class ImageCapture.Defaults
implements ConfigProvider<ImageCaptureConfig> {
    private static final int DEFAULT_ASPECT_RATIO = 0;
    private static final ImageCaptureConfig DEFAULT_CONFIG = new ImageCapture.Builder().setSurfaceOccupancyPriority(4).setTargetAspectRatio(0).getUseCaseConfig();
    private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 4;

    public ImageCaptureConfig getConfig() {
        return DEFAULT_CONFIG;
    }
}
