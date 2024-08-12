/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.view.transform.ImageProxyTransformFactory
 */
package androidx.camera.view.transform;

import androidx.camera.view.transform.ImageProxyTransformFactory;

public static class ImageProxyTransformFactory.Builder {
    private boolean mUseCropRect = false;
    private boolean mUseRotationDegrees = false;

    public ImageProxyTransformFactory build() {
        return new ImageProxyTransformFactory(this.mUseCropRect, this.mUseRotationDegrees);
    }

    public ImageProxyTransformFactory.Builder setUseCropRect(boolean bl) {
        this.mUseCropRect = bl;
        return this;
    }

    public ImageProxyTransformFactory.Builder setUseRotationDegrees(boolean bl) {
        this.mUseRotationDegrees = bl;
        return this;
    }
}
