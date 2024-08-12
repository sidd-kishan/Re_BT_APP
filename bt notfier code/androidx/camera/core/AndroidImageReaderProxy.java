/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.Image
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.view.Surface
 *  androidx.camera.core.AndroidImageProxy
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core._$$Lambda$AndroidImageReaderProxy$1j5V93NALzdEKViOyKnqPUbnDDk
 *  androidx.camera.core._$$Lambda$AndroidImageReaderProxy$RyV51268LxqXqf_5yS6H_QoqpDY
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 *  androidx.camera.core.impl.utils.MainThreadAsyncHandler
 */
package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import androidx.camera.core.AndroidImageProxy;
import androidx.camera.core.ImageProxy;
import androidx.camera.core._$;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.concurrent.Executor;

final class AndroidImageReaderProxy
implements ImageReaderProxy {
    private final ImageReader mImageReader;

    AndroidImageReaderProxy(ImageReader imageReader) {
        this.mImageReader = imageReader;
    }

    private boolean isImageReaderContextNotInitializedException(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public ImageProxy acquireLatestImage() {
        synchronized (this) {
            Throwable throwable22;
            Image image;
            block6: {
                try {
                    try {
                        image = this.mImageReader.acquireLatestImage();
                    }
                    catch (RuntimeException runtimeException) {
                        boolean bl = this.isImageReaderContextNotInitializedException(runtimeException);
                        if (!bl) throw runtimeException;
                        return null;
                    }
                    if (image != null) break block6;
                }
                catch (Throwable throwable22) {}
                return null;
            }
            return new AndroidImageProxy(image);
            throw throwable22;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public ImageProxy acquireNextImage() {
        synchronized (this) {
            Throwable throwable22;
            Image image;
            block6: {
                try {
                    try {
                        image = this.mImageReader.acquireNextImage();
                    }
                    catch (RuntimeException runtimeException) {
                        boolean bl = this.isImageReaderContextNotInitializedException(runtimeException);
                        if (!bl) throw runtimeException;
                        return null;
                    }
                    if (image != null) break block6;
                }
                catch (Throwable throwable22) {}
                return null;
            }
            return new AndroidImageProxy(image);
            throw throwable22;
        }
    }

    public void clearOnImageAvailableListener() {
        synchronized (this) {
            this.mImageReader.setOnImageAvailableListener(null, null);
            return;
        }
    }

    public void close() {
        synchronized (this) {
            this.mImageReader.close();
            return;
        }
    }

    public int getHeight() {
        synchronized (this) {
            int n = this.mImageReader.getHeight();
            return n;
        }
    }

    public int getImageFormat() {
        synchronized (this) {
            int n = this.mImageReader.getImageFormat();
            return n;
        }
    }

    public int getMaxImages() {
        synchronized (this) {
            int n = this.mImageReader.getMaxImages();
            return n;
        }
    }

    public Surface getSurface() {
        synchronized (this) {
            Surface surface = this.mImageReader.getSurface();
            return surface;
        }
    }

    public int getWidth() {
        synchronized (this) {
            int n = this.mImageReader.getWidth();
            return n;
        }
    }

    public /* synthetic */ void lambda$setOnImageAvailableListener$0$AndroidImageReaderProxy(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        onImageAvailableListener.onImageAvailable((ImageReaderProxy)this);
    }

    public /* synthetic */ void lambda$setOnImageAvailableListener$1$AndroidImageReaderProxy(Executor executor, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, ImageReader imageReader) {
        executor.execute((Runnable)new _$.Lambda.AndroidImageReaderProxy.RyV51268LxqXqf_5yS6H_QoqpDY(this, onImageAvailableListener));
    }

    public void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
        synchronized (this) {
            _$.Lambda.AndroidImageReaderProxy.1j5V93NALzdEKViOyKnqPUbnDDk j5V93NALzdEKViOyKnqPUbnDDk = new _$.Lambda.AndroidImageReaderProxy.1j5V93NALzdEKViOyKnqPUbnDDk(this, executor, onImageAvailableListener);
            this.mImageReader.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)j5V93NALzdEKViOyKnqPUbnDDk, MainThreadAsyncHandler.getInstance());
            return;
        }
    }
}
