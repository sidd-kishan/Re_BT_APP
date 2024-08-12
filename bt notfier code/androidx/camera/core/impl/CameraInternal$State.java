/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static final class CameraInternal.State
extends Enum<CameraInternal.State> {
    private static final CameraInternal.State[] $VALUES;
    public static final /* enum */ CameraInternal.State CLOSED;
    public static final /* enum */ CameraInternal.State CLOSING;
    public static final /* enum */ CameraInternal.State OPEN;
    public static final /* enum */ CameraInternal.State OPENING;
    public static final /* enum */ CameraInternal.State PENDING_OPEN;
    public static final /* enum */ CameraInternal.State RELEASED;
    public static final /* enum */ CameraInternal.State RELEASING;
    private final boolean mHoldsCameraSlot;

    static {
        CameraInternal.State state;
        PENDING_OPEN = new CameraInternal.State(false);
        OPENING = new CameraInternal.State(true);
        OPEN = new CameraInternal.State(true);
        CLOSING = new CameraInternal.State(true);
        CLOSED = new CameraInternal.State(false);
        RELEASING = new CameraInternal.State(true);
        RELEASED = state = new CameraInternal.State(false);
        $VALUES = new CameraInternal.State[]{PENDING_OPEN, OPENING, OPEN, CLOSING, CLOSED, RELEASING, state};
    }

    private CameraInternal.State(boolean bl) {
        this.mHoldsCameraSlot = bl;
    }

    public static CameraInternal.State valueOf(String string) {
        return Enum.valueOf(CameraInternal.State.class, string);
    }

    public static CameraInternal.State[] values() {
        return (CameraInternal.State[])$VALUES.clone();
    }

    boolean holdsCameraSlot() {
        return this.mHoldsCameraSlot;
    }
}
