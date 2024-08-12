/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageProxyDownsampler$DownsamplingMethod
 */
package androidx.camera.core;

import androidx.camera.core.ImageProxyDownsampler;

/*
 * Exception performing whole class analysis ignored.
 */
static class ImageProxyDownsampler.2 {
    static final int[] $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ImageProxyDownsampler.DownsamplingMethod.values().length];
        $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod = nArray;
        try {
            nArray[ImageProxyDownsampler.DownsamplingMethod.NEAREST_NEIGHBOR.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ImageProxyDownsampler.2.$SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod[ImageProxyDownsampler.DownsamplingMethod.AVERAGING.ordinal()] = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
