/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.ForwardingImageProxy$OnImageCloseListener
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.SingleCloseImageProxy
 *  androidx.camera.core._$$Lambda$SafeCloseImageReaderProxy$VO_yHRAHpdG2MqCxQDiZeplGJKU
 *  androidx.camera.core._$$Lambda$SafeCloseImageReaderProxy$pee6fgxnPrlEv40Nqz6ZqBNSPGI
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SingleCloseImageProxy;
import androidx.camera.core._$;
import androidx.camera.core.impl.ImageReaderProxy;
import java.util.concurrent.Executor;

class SafeCloseImageReaderProxy
implements ImageReaderProxy {
    private ForwardingImageProxy.OnImageCloseListener mImageCloseListener;
    private final ImageReaderProxy mImageReaderProxy;
    private volatile boolean mIsClosed = false;
    private final Object mLock = new Object();
    private volatile int mOutstandingImages = 0;
    private final Surface mSurface;

    SafeCloseImageReaderProxy(ImageReaderProxy imageReaderProxy) {
        this.mImageCloseListener = new _$.Lambda.SafeCloseImageReaderProxy.pee6fgxnPrlEv40Nqz6ZqBNSPGI(this);
        this.mImageReaderProxy = imageReaderProxy;
        this.mSurface = imageReaderProxy.getSurface();
    }

    private ImageProxy wrapImageProxy(ImageProxy imageProxy) {
        Object object = this.mLock;
        synchronized (object) {
            if (imageProxy == null) return null;
            ++this.mOutstandingImages;
            SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(imageProxy);
            singleCloseImageProxy.addOnImageCloseListener(this.mImageCloseListener);
            return singleCloseImageProxy;
        }
    }

    public ImageProxy acquireLatestImage() {
        Object object = this.mLock;
        synchronized (object) {
            ImageProxy imageProxy = this.wrapImageProxy(this.mImageReaderProxy.acquireLatestImage());
            return imageProxy;
        }
    }

    public ImageProxy acquireNextImage() {
        Object object = this.mLock;
        synchronized (object) {
            ImageProxy imageProxy = this.wrapImageProxy(this.mImageReaderProxy.acquireNextImage());
            return imageProxy;
        }
    }

    public void clearOnImageAvailableListener() {
        Object object = this.mLock;
        synchronized (object) {
            this.mImageReaderProxy.clearOnImageAvailableListener();
            return;
        }
    }

    public void close() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mSurface != null) {
                this.mSurface.release();
            }
            this.mImageReaderProxy.close();
            return;
        }
    }

    public int getHeight() {
        Object object = this.mLock;
        synchronized (object) {
            int n = this.mImageReaderProxy.getHeight();
            return n;
        }
    }

    public int getImageFormat() {
        Object object = this.mLock;
        synchronized (object) {
            int n = this.mImageReaderProxy.getImageFormat();
            return n;
        }
    }

    public int getMaxImages() {
        Object object = this.mLock;
        synchronized (object) {
            int n = this.mImageReaderProxy.getMaxImages();
            return n;
        }
    }

    public Surface getSurface() {
        Object object = this.mLock;
        synchronized (object) {
            Surface surface = this.mImageReaderProxy.getSurface();
            return surface;
        }
    }

    public int getWidth() {
        Object object = this.mLock;
        synchronized (object) {
            int n = this.mImageReaderProxy.getWidth();
            return n;
        }
    }

    public /* synthetic */ void lambda$new$0$SafeCloseImageReaderProxy(ImageProxy object) {
        object = this.mLock;
        synchronized (object) {
            --this.mOutstandingImages;
            if (!this.mIsClosed) return;
            if (this.mOutstandingImages != 0) return;
            this.close();
            return;
        }
    }

    public /* synthetic */ void lambda$setOnImageAvailableListener$1$SafeCloseImageReaderProxy(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, ImageReaderProxy imageReaderProxy) {
        onImageAvailableListener.onImageAvailable((ImageReaderProxy)this);
    }

    void safeClose() {
        Object object = this.mLock;
        synchronized (object) {
            this.mIsClosed = true;
            this.mImageReaderProxy.clearOnImageAvailableListener();
            if (this.mOutstandingImages != 0) return;
            this.close();
            return;
        }
    }

    public void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            _$.Lambda.SafeCloseImageReaderProxy.VO_yHRAHpdG2MqCxQDiZeplGJKU vO_yHRAHpdG2MqCxQDiZeplGJKU = new _$.Lambda.SafeCloseImageReaderProxy.VO_yHRAHpdG2MqCxQDiZeplGJKU(this, onImageAvailableListener);
            imageReaderProxy.setOnImageAvailableListener((ImageReaderProxy.OnImageAvailableListener)vO_yHRAHpdG2MqCxQDiZeplGJKU, executor);
            return;
        }
    }
}
