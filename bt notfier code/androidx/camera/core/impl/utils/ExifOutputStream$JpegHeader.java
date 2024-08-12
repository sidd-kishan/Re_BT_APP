/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils;

static final class ExifOutputStream.JpegHeader {
    public static final short APP1 = -31;
    public static final short DAC = -52;
    public static final short DHT = -60;
    public static final short EOI = -39;
    public static final short JPG = -56;
    public static final short SOF0 = -64;
    public static final short SOF15 = -49;
    public static final short SOI = -40;

    private ExifOutputStream.JpegHeader() {
    }

    public static boolean isSofMarker(short s) {
        boolean bl = s >= -64 && s <= -49 && s != -60 && s != -56 && s != -52;
        return bl;
    }
}
