/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageSaver$SaveError
 */
package androidx.camera.core;

import androidx.camera.core.ImageSaver;

static class ImageCapture.9 {
    static final int[] $SwitchMap$androidx$camera$core$ImageSaver$SaveError;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ImageSaver.SaveError.values().length];
        $SwitchMap$androidx$camera$core$ImageSaver$SaveError = nArray;
        try {
            nArray[ImageSaver.SaveError.FILE_IO_FAILED.ordinal()] = 1;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
