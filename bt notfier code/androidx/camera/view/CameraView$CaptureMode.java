/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.view;

public static final class CameraView.CaptureMode
extends Enum<CameraView.CaptureMode> {
    private static final CameraView.CaptureMode[] $VALUES;
    public static final /* enum */ CameraView.CaptureMode IMAGE;
    public static final /* enum */ CameraView.CaptureMode MIXED;
    public static final /* enum */ CameraView.CaptureMode VIDEO;
    private final int mId;

    static {
        CameraView.CaptureMode captureMode;
        IMAGE = new CameraView.CaptureMode(0);
        VIDEO = new CameraView.CaptureMode(1);
        MIXED = captureMode = new CameraView.CaptureMode(2);
        $VALUES = new CameraView.CaptureMode[]{IMAGE, VIDEO, captureMode};
    }

    private CameraView.CaptureMode(int n2) {
        this.mId = n2;
    }

    static CameraView.CaptureMode fromId(int n) {
        Object object = CameraView.CaptureMode.values();
        int n2 = ((CameraView.CaptureMode[])object).length;
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                object = new IllegalArgumentException();
                throw object;
            }
            CameraView.CaptureMode captureMode = object[n3];
            if (captureMode.mId == n) {
                return captureMode;
            }
            ++n3;
        }
    }

    public static CameraView.CaptureMode valueOf(String string) {
        return Enum.valueOf(CameraView.CaptureMode.class, string);
    }

    public static CameraView.CaptureMode[] values() {
        return (CameraView.CaptureMode[])$VALUES.clone();
    }

    int getId() {
        return this.mId;
    }
}
