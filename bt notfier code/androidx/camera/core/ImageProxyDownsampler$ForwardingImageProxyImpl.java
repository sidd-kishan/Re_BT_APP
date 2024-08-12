/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ForwardingImageProxy
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.ImageProxy$PlaneProxy
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProxy;

private static final class ImageProxyDownsampler.ForwardingImageProxyImpl
extends ForwardingImageProxy {
    private final int mDownsampledHeight;
    private final ImageProxy.PlaneProxy[] mDownsampledPlanes;
    private final int mDownsampledWidth;

    ImageProxyDownsampler.ForwardingImageProxyImpl(ImageProxy imageProxy, ImageProxy.PlaneProxy[] planeProxyArray, int n, int n2) {
        super(imageProxy);
        this.mDownsampledPlanes = planeProxyArray;
        this.mDownsampledWidth = n;
        this.mDownsampledHeight = n2;
    }

    public int getHeight() {
        synchronized (this) {
            int n = this.mDownsampledHeight;
            return n;
        }
    }

    public ImageProxy.PlaneProxy[] getPlanes() {
        synchronized (this) {
            ImageProxy.PlaneProxy[] planeProxyArray = this.mDownsampledPlanes;
            return planeProxyArray;
        }
    }

    public int getWidth() {
        synchronized (this) {
            int n = this.mDownsampledWidth;
            return n;
        }
    }
}
