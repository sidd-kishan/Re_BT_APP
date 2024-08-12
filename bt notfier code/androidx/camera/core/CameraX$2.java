/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraX$InternalInitState
 */
package androidx.camera.core;

import androidx.camera.core.CameraX;

/*
 * Exception performing whole class analysis ignored.
 */
static class CameraX.2 {
    static final int[] $SwitchMap$androidx$camera$core$CameraX$InternalInitState;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[CameraX.InternalInitState.values().length];
        $SwitchMap$androidx$camera$core$CameraX$InternalInitState = nArray;
        try {
            nArray[CameraX.InternalInitState.UNINITIALIZED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            CameraX.2.$SwitchMap$androidx$camera$core$CameraX$InternalInitState[CameraX.InternalInitState.INITIALIZING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            CameraX.2.$SwitchMap$androidx$camera$core$CameraX$InternalInitState[CameraX.InternalInitState.INITIALIZED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            CameraX.2.$SwitchMap$androidx$camera$core$CameraX$InternalInitState[CameraX.InternalInitState.SHUTDOWN.ordinal()] = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
