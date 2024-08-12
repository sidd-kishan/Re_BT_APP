/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.SurfaceConfig
 *  androidx.camera.core.impl.SurfaceConfig$ConfigSize
 *  androidx.camera.core.impl.SurfaceConfig$ConfigType
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.SurfaceConfig;

final class AutoValue_SurfaceConfig
extends SurfaceConfig {
    private final SurfaceConfig.ConfigSize configSize;
    private final SurfaceConfig.ConfigType configType;

    AutoValue_SurfaceConfig(SurfaceConfig.ConfigType configType, SurfaceConfig.ConfigSize configSize) {
        if (configType == null) throw new NullPointerException("Null configType");
        this.configType = configType;
        if (configSize == null) throw new NullPointerException("Null configSize");
        this.configSize = configSize;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof SurfaceConfig)) return false;
        if (this.configType.equals((Object)(object = (SurfaceConfig)object).getConfigType()) && this.configSize.equals((Object)object.getConfigSize())) return bl;
        bl = false;
        return bl;
    }

    public SurfaceConfig.ConfigSize getConfigSize() {
        return this.configSize;
    }

    public SurfaceConfig.ConfigType getConfigType() {
        return this.configType;
    }

    public int hashCode() {
        return (this.configType.hashCode() ^ 0xF4243) * 1000003 ^ this.configSize.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SurfaceConfig{configType=");
        stringBuilder.append(this.configType);
        stringBuilder.append(", configSize=");
        stringBuilder.append(this.configSize);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
