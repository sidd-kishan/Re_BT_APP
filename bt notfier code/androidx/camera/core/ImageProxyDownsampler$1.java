/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageProxy$PlaneProxy
 */
package androidx.camera.core;

import androidx.camera.core.ImageProxy;
import java.nio.ByteBuffer;

class ImageProxyDownsampler.1
implements ImageProxy.PlaneProxy {
    final ByteBuffer mBuffer;
    final byte[] val$data;
    final int val$pixelStride;
    final int val$rowStride;

    ImageProxyDownsampler.1(byte[] byArray, int n, int n2) {
        this.val$data = byArray;
        this.val$rowStride = n;
        this.val$pixelStride = n2;
        this.mBuffer = ByteBuffer.wrap(this.val$data);
    }

    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    public int getPixelStride() {
        return this.val$pixelStride;
    }

    public int getRowStride() {
        return this.val$rowStride;
    }
}
