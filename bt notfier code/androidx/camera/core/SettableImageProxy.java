/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Size
 *  androidx.camera.core.ForwardingImageProxy
 *  androidx.camera.core.ImageInfo
 *  androidx.camera.core.ImageProxy
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;

final class SettableImageProxy
extends ForwardingImageProxy {
    private Rect mCropRect;
    private final int mHeight;
    private final ImageInfo mImageInfo;
    private final int mWidth;

    SettableImageProxy(ImageProxy imageProxy, Size size, ImageInfo imageInfo) {
        super(imageProxy);
        if (size == null) {
            this.mWidth = super.getWidth();
            this.mHeight = super.getHeight();
        } else {
            this.mWidth = size.getWidth();
            this.mHeight = size.getHeight();
        }
        this.mImageInfo = imageInfo;
    }

    SettableImageProxy(ImageProxy imageProxy, ImageInfo imageInfo) {
        this(imageProxy, null, imageInfo);
    }

    public Rect getCropRect() {
        synchronized (this) {
            if (this.mCropRect == null) {
                Rect rect = new Rect(0, 0, this.getWidth(), this.getHeight());
                return rect;
            }
            Rect rect = new Rect(this.mCropRect);
            return rect;
        }
    }

    public int getHeight() {
        synchronized (this) {
            int n = this.mHeight;
            return n;
        }
    }

    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public int getWidth() {
        synchronized (this) {
            int n = this.mWidth;
            return n;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void setCropRect(Rect rect) {
        synchronized (this) {
            Rect rect2 = rect;
            if (rect != null && !(rect2 = new Rect(rect)).intersect(0, 0, this.getWidth(), this.getHeight())) {
                rect2.setEmpty();
            }
            this.mCropRect = rect2;
            return;
        }
    }
}
