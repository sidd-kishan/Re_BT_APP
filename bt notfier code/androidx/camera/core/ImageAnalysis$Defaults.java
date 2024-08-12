/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.ImageAnalysis$Builder
 *  androidx.camera.core.impl.ConfigProvider
 *  androidx.camera.core.impl.ImageAnalysisConfig
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageAnalysisConfig;

public static final class ImageAnalysis.Defaults
implements ConfigProvider<ImageAnalysisConfig> {
    private static final int DEFAULT_ASPECT_RATIO = 0;
    private static final ImageAnalysisConfig DEFAULT_CONFIG;
    private static final Size DEFAULT_MAX_RESOLUTION;
    private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 1;
    private static final Size DEFAULT_TARGET_RESOLUTION;

    static {
        DEFAULT_TARGET_RESOLUTION = new Size(640, 480);
        DEFAULT_MAX_RESOLUTION = new Size(1920, 1080);
        DEFAULT_CONFIG = new ImageAnalysis.Builder().setDefaultResolution(DEFAULT_TARGET_RESOLUTION).setMaxResolution(DEFAULT_MAX_RESOLUTION).setSurfaceOccupancyPriority(1).setTargetAspectRatio(0).getUseCaseConfig();
    }

    public ImageAnalysisConfig getConfig() {
        return DEFAULT_CONFIG;
    }
}
