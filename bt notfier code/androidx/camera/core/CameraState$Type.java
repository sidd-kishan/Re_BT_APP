/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core;

public static final class CameraState.Type
extends Enum<CameraState.Type> {
    private static final CameraState.Type[] $VALUES;
    public static final /* enum */ CameraState.Type CLOSED;
    public static final /* enum */ CameraState.Type CLOSING;
    public static final /* enum */ CameraState.Type OPEN;
    public static final /* enum */ CameraState.Type OPENING;
    public static final /* enum */ CameraState.Type PENDING_OPEN;

    static {
        CameraState.Type type;
        PENDING_OPEN = new CameraState.Type();
        OPENING = new CameraState.Type();
        OPEN = new CameraState.Type();
        CLOSING = new CameraState.Type();
        CLOSED = type = new CameraState.Type();
        $VALUES = new CameraState.Type[]{PENDING_OPEN, OPENING, OPEN, CLOSING, type};
    }

    public static CameraState.Type valueOf(String string) {
        return Enum.valueOf(CameraState.Type.class, string);
    }

    public static CameraState.Type[] values() {
        return (CameraState.Type[])$VALUES.clone();
    }
}
