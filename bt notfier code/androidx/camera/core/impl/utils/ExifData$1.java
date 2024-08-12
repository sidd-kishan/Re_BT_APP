/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraCaptureMetaData$FlashState
 *  androidx.camera.core.impl.utils.ExifData$WhiteBalanceMode
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.utils.ExifData;

/*
 * Exception performing whole class analysis ignored.
 */
static class ExifData.1 {
    static final int[] $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState;
    static final int[] $SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ExifData.WhiteBalanceMode.values().length];
        $SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode = nArray;
        try {
            nArray[ExifData.WhiteBalanceMode.AUTO.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ExifData.1.$SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode[ExifData.WhiteBalanceMode.MANUAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        nArray = new int[CameraCaptureMetaData.FlashState.values().length];
        $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState = nArray;
        try {
            nArray[CameraCaptureMetaData.FlashState.READY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ExifData.1.$SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[CameraCaptureMetaData.FlashState.NONE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ExifData.1.$SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[CameraCaptureMetaData.FlashState.FIRED.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
