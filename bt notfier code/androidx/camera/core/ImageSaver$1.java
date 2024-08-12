/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType
 */
package androidx.camera.core;

import androidx.camera.core.internal.utils.ImageUtil;

static class ImageSaver.1 {
    static final int[] $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ImageUtil.CodecFailedException.FailureType.values().length];
        $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType = nArray;
        try {
            nArray[ImageUtil.CodecFailedException.FailureType.ENCODE_FAILED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ImageSaver.1.$SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType[ImageUtil.CodecFailedException.FailureType.DECODE_FAILED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ImageSaver.1.$SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType[ImageUtil.CodecFailedException.FailureType.UNKNOWN.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
