/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.AutoValue_SurfaceConfig
 *  androidx.camera.core.impl.SurfaceConfig$ConfigSize
 *  androidx.camera.core.impl.SurfaceConfig$ConfigType
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.AutoValue_SurfaceConfig;
import androidx.camera.core.impl.SurfaceConfig;

public abstract class SurfaceConfig {
    SurfaceConfig() {
    }

    public static SurfaceConfig create(ConfigType configType, ConfigSize configSize) {
        return new AutoValue_SurfaceConfig(configType, configSize);
    }

    public abstract ConfigSize getConfigSize();

    public abstract ConfigType getConfigType();

    public final boolean isSupported(SurfaceConfig surfaceConfig) {
        ConfigType configType = surfaceConfig.getConfigType();
        boolean bl = surfaceConfig.getConfigSize().getId() <= this.getConfigSize().getId() && configType == this.getConfigType();
        return bl;
    }
}
