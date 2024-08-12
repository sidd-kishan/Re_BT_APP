/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.media.Image
 *  android.media.Image$Plane
 *  androidx.camera.core.AndroidImageProxy$PlaneProxy
 *  androidx.camera.core.ImageInfo
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.ImageProxy$PlaneProxy
 *  androidx.camera.core.ImmutableImageInfo
 *  androidx.camera.core.impl.TagBundle
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.AndroidImageProxy;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImmutableImageInfo;
import androidx.camera.core.impl.TagBundle;

final class AndroidImageProxy
implements ImageProxy {
    private final Image mImage;
    private final ImageInfo mImageInfo;
    private final PlaneProxy[] mPlanes;

    AndroidImageProxy(Image image) {
        this.mImage = image;
        Image.Plane[] planeArray = image.getPlanes();
        if (planeArray != null) {
            this.mPlanes = new PlaneProxy[planeArray.length];
            for (int i = 0; i < planeArray.length; ++i) {
                this.mPlanes[i] = new PlaneProxy(planeArray[i]);
            }
        } else {
            this.mPlanes = new PlaneProxy[0];
        }
        this.mImageInfo = ImmutableImageInfo.create((TagBundle)TagBundle.emptyBundle(), (long)image.getTimestamp(), (int)0);
    }

    public void close() {
        synchronized (this) {
            this.mImage.close();
            return;
        }
    }

    public Rect getCropRect() {
        synchronized (this) {
            Rect rect = this.mImage.getCropRect();
            return rect;
        }
    }

    public int getFormat() {
        synchronized (this) {
            int n = this.mImage.getFormat();
            return n;
        }
    }

    public int getHeight() {
        synchronized (this) {
            int n = this.mImage.getHeight();
            return n;
        }
    }

    public Image getImage() {
        synchronized (this) {
            Image image = this.mImage;
            return image;
        }
    }

    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public ImageProxy.PlaneProxy[] getPlanes() {
        synchronized (this) {
            PlaneProxy[] planeProxyArray = this.mPlanes;
            return planeProxyArray;
        }
    }

    public int getWidth() {
        synchronized (this) {
            int n = this.mImage.getWidth();
            return n;
        }
    }

    public void setCropRect(Rect rect) {
        synchronized (this) {
            this.mImage.setCropRect(rect);
            return;
        }
    }
}
