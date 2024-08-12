/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.media.Image
 *  androidx.camera.core.ForwardingImageProxy$OnImageCloseListener
 *  androidx.camera.core.ImageInfo
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.ImageProxy$PlaneProxy
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import java.util.HashSet;
import java.util.Set;

abstract class ForwardingImageProxy
implements ImageProxy {
    protected final ImageProxy mImage;
    private final Set<OnImageCloseListener> mOnImageCloseListeners = new HashSet<OnImageCloseListener>();

    protected ForwardingImageProxy(ImageProxy imageProxy) {
        this.mImage = imageProxy;
    }

    void addOnImageCloseListener(OnImageCloseListener onImageCloseListener) {
        synchronized (this) {
            this.mOnImageCloseListeners.add(onImageCloseListener);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void close() {
        synchronized (this) {
            this.mImage.close();
        }
        this.notifyOnImageCloseListeners();
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
            Image image = this.mImage.getImage();
            return image;
        }
    }

    public ImageInfo getImageInfo() {
        synchronized (this) {
            ImageInfo imageInfo = this.mImage.getImageInfo();
            return imageInfo;
        }
    }

    public ImageProxy.PlaneProxy[] getPlanes() {
        synchronized (this) {
            ImageProxy.PlaneProxy[] planeProxyArray = this.mImage.getPlanes();
            return planeProxyArray;
        }
    }

    public int getWidth() {
        synchronized (this) {
            int n = this.mImage.getWidth();
            return n;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    protected void notifyOnImageCloseListeners() {
        Object object;
        synchronized (this) {
            object = new HashSet(this.mOnImageCloseListeners);
            // MONITOREXIT @DISABLED, blocks:[0, 2] lbl4 : MonitorExitStatement: MONITOREXIT : this
            object = object.iterator();
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        while (object.hasNext()) {
            ((OnImageCloseListener)object.next()).onImageClose((ImageProxy)this);
        }
    }

    public void setCropRect(Rect rect) {
        synchronized (this) {
            this.mImage.setCropRect(rect);
            return;
        }
    }
}
