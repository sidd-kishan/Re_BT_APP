/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static final class SurfaceConfig.ConfigSize
extends Enum<SurfaceConfig.ConfigSize> {
    private static final SurfaceConfig.ConfigSize[] $VALUES;
    public static final /* enum */ SurfaceConfig.ConfigSize ANALYSIS;
    public static final /* enum */ SurfaceConfig.ConfigSize MAXIMUM;
    public static final /* enum */ SurfaceConfig.ConfigSize NOT_SUPPORT;
    public static final /* enum */ SurfaceConfig.ConfigSize PREVIEW;
    public static final /* enum */ SurfaceConfig.ConfigSize RECORD;
    final int mId;

    static {
        SurfaceConfig.ConfigSize configSize;
        ANALYSIS = new SurfaceConfig.ConfigSize(0);
        PREVIEW = new SurfaceConfig.ConfigSize(1);
        RECORD = new SurfaceConfig.ConfigSize(2);
        MAXIMUM = new SurfaceConfig.ConfigSize(3);
        NOT_SUPPORT = configSize = new SurfaceConfig.ConfigSize(4);
        $VALUES = new SurfaceConfig.ConfigSize[]{ANALYSIS, PREVIEW, RECORD, MAXIMUM, configSize};
    }

    private SurfaceConfig.ConfigSize(int n2) {
        this.mId = n2;
    }

    public static SurfaceConfig.ConfigSize valueOf(String string) {
        return Enum.valueOf(SurfaceConfig.ConfigSize.class, string);
    }

    public static SurfaceConfig.ConfigSize[] values() {
        return (SurfaceConfig.ConfigSize[])$VALUES.clone();
    }

    int getId() {
        return this.mId;
    }
}
