/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core;

private static final class CameraX.InternalInitState
extends Enum<CameraX.InternalInitState> {
    private static final CameraX.InternalInitState[] $VALUES;
    public static final /* enum */ CameraX.InternalInitState INITIALIZED;
    public static final /* enum */ CameraX.InternalInitState INITIALIZING;
    public static final /* enum */ CameraX.InternalInitState SHUTDOWN;
    public static final /* enum */ CameraX.InternalInitState UNINITIALIZED;

    static {
        CameraX.InternalInitState internalInitState;
        UNINITIALIZED = new CameraX.InternalInitState();
        INITIALIZING = new CameraX.InternalInitState();
        INITIALIZED = new CameraX.InternalInitState();
        SHUTDOWN = internalInitState = new CameraX.InternalInitState();
        $VALUES = new CameraX.InternalInitState[]{UNINITIALIZED, INITIALIZING, INITIALIZED, internalInitState};
    }

    public static CameraX.InternalInitState valueOf(String string) {
        return Enum.valueOf(CameraX.InternalInitState.class, string);
    }

    public static CameraX.InternalInitState[] values() {
        return (CameraX.InternalInitState[])$VALUES.clone();
    }
}
