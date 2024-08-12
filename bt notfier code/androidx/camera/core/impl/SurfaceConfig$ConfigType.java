/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static final class SurfaceConfig.ConfigType
extends Enum<SurfaceConfig.ConfigType> {
    private static final SurfaceConfig.ConfigType[] $VALUES;
    public static final /* enum */ SurfaceConfig.ConfigType JPEG;
    public static final /* enum */ SurfaceConfig.ConfigType PRIV;
    public static final /* enum */ SurfaceConfig.ConfigType RAW;
    public static final /* enum */ SurfaceConfig.ConfigType YUV;

    static {
        SurfaceConfig.ConfigType configType;
        PRIV = new SurfaceConfig.ConfigType();
        YUV = new SurfaceConfig.ConfigType();
        JPEG = new SurfaceConfig.ConfigType();
        RAW = configType = new SurfaceConfig.ConfigType();
        $VALUES = new SurfaceConfig.ConfigType[]{PRIV, YUV, JPEG, configType};
    }

    public static SurfaceConfig.ConfigType valueOf(String string) {
        return Enum.valueOf(SurfaceConfig.ConfigType.class, string);
    }

    public static SurfaceConfig.ConfigType[] values() {
        return (SurfaceConfig.ConfigType[])$VALUES.clone();
    }
}
