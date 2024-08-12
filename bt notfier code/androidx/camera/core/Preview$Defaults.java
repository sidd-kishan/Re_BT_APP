/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Preview$Builder
 *  androidx.camera.core.impl.ConfigProvider
 *  androidx.camera.core.impl.PreviewConfig
 */
package androidx.camera.core;

import androidx.camera.core.Preview;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.PreviewConfig;

public static final class Preview.Defaults
implements ConfigProvider<PreviewConfig> {
    private static final int DEFAULT_ASPECT_RATIO = 0;
    private static final PreviewConfig DEFAULT_CONFIG = new Preview.Builder().setSurfaceOccupancyPriority(2).setTargetAspectRatio(0).getUseCaseConfig();
    private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 2;

    public PreviewConfig getConfig() {
        return DEFAULT_CONFIG;
    }
}
