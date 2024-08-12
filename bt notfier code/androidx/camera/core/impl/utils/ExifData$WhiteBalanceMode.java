/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils;

public static final class ExifData.WhiteBalanceMode
extends Enum<ExifData.WhiteBalanceMode> {
    private static final ExifData.WhiteBalanceMode[] $VALUES;
    public static final /* enum */ ExifData.WhiteBalanceMode AUTO;
    public static final /* enum */ ExifData.WhiteBalanceMode MANUAL;

    static {
        ExifData.WhiteBalanceMode whiteBalanceMode;
        AUTO = new ExifData.WhiteBalanceMode();
        MANUAL = whiteBalanceMode = new ExifData.WhiteBalanceMode();
        $VALUES = new ExifData.WhiteBalanceMode[]{AUTO, whiteBalanceMode};
    }

    public static ExifData.WhiteBalanceMode valueOf(String string) {
        return Enum.valueOf(ExifData.WhiteBalanceMode.class, string);
    }

    public static ExifData.WhiteBalanceMode[] values() {
        return (ExifData.WhiteBalanceMode[])$VALUES.clone();
    }
}
