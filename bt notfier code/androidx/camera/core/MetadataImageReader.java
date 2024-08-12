/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.util.LongSparseArray
 *  android.view.Surface
 *  androidx.camera.core.AndroidImageReaderProxy
 *  androidx.camera.core.ForwardingImageProxy$OnImageCloseListener
 *  androidx.camera.core.ImageInfo
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.Logger
 *  androidx.camera.core.SettableImageProxy
 *  androidx.camera.core._$$Lambda$MetadataImageReader$8HL2vw_DsR0m0aXoFgsFnlVPkmY
 *  androidx.camera.core._$$Lambda$MetadataImageReader$DONJ_Tb_b_WYV8EceE_yMZTG_HA
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 *  androidx.camera.core.internal.CameraCaptureResultImageInfo
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.camera.core.AndroidImageReaderProxy;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core._$;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

class MetadataImageReader
implements ImageReaderProxy,
ForwardingImageProxy.OnImageCloseListener {
    private static final String TAG = "MetadataImageReader";
    private final List<ImageProxy> mAcquiredImageProxies;
    private CameraCaptureCallback mCameraCaptureCallback;
    private boolean mClosed = false;
    private Executor mExecutor;
    private int mImageProxiesIndex;
    private final ImageReaderProxy mImageReaderProxy;
    ImageReaderProxy.OnImageAvailableListener mListener;
    private final Object mLock = new Object();
    private final List<ImageProxy> mMatchedImageProxies;
    private final LongSparseArray<ImageInfo> mPendingImageInfos;
    private final LongSparseArray<ImageProxy> mPendingImages;
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener;

    MetadataImageReader(int n, int n2, int n3, int n4) {
        this(MetadataImageReader.createImageReaderProxy(n, n2, n3, n4));
    }

    MetadataImageReader(ImageReaderProxy imageReaderProxy) {
        this.mCameraCaptureCallback = new /* Unavailable Anonymous Inner Class!! */;
        this.mTransformedListener = new _$.Lambda.MetadataImageReader.DONJ_Tb_b_WYV8EceE_yMZTG_HA(this);
        this.mPendingImageInfos = new LongSparseArray();
        this.mPendingImages = new LongSparseArray();
        this.mAcquiredImageProxies = new ArrayList<ImageProxy>();
        this.mImageReaderProxy = imageReaderProxy;
        this.mImageProxiesIndex = 0;
        this.mMatchedImageProxies = new ArrayList<ImageProxy>(this.getMaxImages());
    }

    private static ImageReaderProxy createImageReaderProxy(int n, int n2, int n3, int n4) {
        return new AndroidImageReaderProxy(ImageReader.newInstance((int)n, (int)n2, (int)n3, (int)n4));
    }

    private void dequeImageProxy(ImageProxy imageProxy) {
        Object object = this.mLock;
        synchronized (object) {
            int n = this.mMatchedImageProxies.indexOf(imageProxy);
            if (n >= 0) {
                this.mMatchedImageProxies.remove(n);
                if (n <= this.mImageProxiesIndex) {
                    --this.mImageProxiesIndex;
                }
            }
            this.mAcquiredImageProxies.remove(imageProxy);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void enqueueImageProxy(SettableImageProxy settableImageProxy) {
        Executor executor;
        Object object = this.mLock;
        synchronized (object) {
            int n = this.mMatchedImageProxies.size();
            int n2 = this.getMaxImages();
            Object var5_5 = null;
            if (n < n2) {
                settableImageProxy.addOnImageCloseListener((ForwardingImageProxy.OnImageCloseListener)this);
                this.mMatchedImageProxies.add((ImageProxy)settableImageProxy);
                settableImageProxy = this.mListener;
                executor = this.mExecutor;
            } else {
                Logger.d((String)"TAG", (String)"Maximum image number reached.");
                settableImageProxy.close();
                executor = null;
                settableImageProxy = var5_5;
            }
        }
        if (settableImageProxy == null) return;
        if (executor != null) {
            executor.execute((Runnable)new _$.Lambda.MetadataImageReader.8HL2vw_DsR0m0aXoFgsFnlVPkmY(this, (ImageReaderProxy.OnImageAvailableListener)settableImageProxy));
            return;
        }
        settableImageProxy.onImageAvailable((ImageReaderProxy)this);
    }

    /*
     * Enabled force condition propagation
     */
    private void matchImages() {
        Object object = this.mLock;
        synchronized (object) {
            for (int i = this.mPendingImageInfos.size() - 1; i >= 0; --i) {
                ImageInfo imageInfo = (ImageInfo)this.mPendingImageInfos.valueAt(i);
                long l = imageInfo.getTimestamp();
                ImageProxy imageProxy = (ImageProxy)this.mPendingImages.get(l);
                if (imageProxy == null) continue;
                this.mPendingImages.remove(l);
                this.mPendingImageInfos.removeAt(i);
                SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy, imageInfo);
                this.enqueueImageProxy(settableImageProxy);
            }
            this.removeStaleData();
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    private void removeStaleData() {
        Object object = this.mLock;
        synchronized (object) {
            block11: {
                if (this.mPendingImages.size() == 0) return;
                if (this.mPendingImageInfos.size() == 0) break block11;
                Object object2 = this.mPendingImages;
                boolean bl = false;
                object2 = object2.keyAt(0);
                Long l = this.mPendingImageInfos.keyAt(0);
                if (!l.equals(object2)) {
                    bl = true;
                }
                Preconditions.checkArgument((boolean)bl);
                if (l > (Long)object2) {
                    int n = this.mPendingImages.size() - 1;
                    while (n >= 0) {
                        if (this.mPendingImages.keyAt(n) < l) {
                            ((ImageProxy)this.mPendingImages.valueAt(n)).close();
                            this.mPendingImages.removeAt(n);
                        }
                        --n;
                    }
                    return;
                }
                {
                    int n = this.mPendingImageInfos.size() - 1;
                    while (n >= 0) {
                        if (this.mPendingImageInfos.keyAt(n) < (Long)object2) {
                            this.mPendingImageInfos.removeAt(n);
                        }
                        --n;
                    }
                    return;
                }
            }
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public ImageProxy acquireLatestImage() {
        Object object = this.mLock;
        synchronized (object) {
            block8: {
                int n;
                if (this.mMatchedImageProxies.isEmpty()) {
                    return null;
                }
                if (this.mImageProxiesIndex >= this.mMatchedImageProxies.size()) break block8;
                ImageProxy imageProxy = new ArrayList();
                for (n = 0; n < this.mMatchedImageProxies.size() - 1; ++n) {
                    if (this.mAcquiredImageProxies.contains(this.mMatchedImageProxies.get(n))) continue;
                    imageProxy.add(this.mMatchedImageProxies.get(n));
                }
                imageProxy = imageProxy.iterator();
                while (true) {
                    if (!imageProxy.hasNext()) {
                        this.mImageProxiesIndex = n = this.mMatchedImageProxies.size() - 1;
                        imageProxy = this.mMatchedImageProxies;
                        this.mImageProxiesIndex = n + 1;
                        imageProxy = imageProxy.get(n);
                        this.mAcquiredImageProxies.add(imageProxy);
                        return imageProxy;
                    }
                    ((ImageProxy)imageProxy.next()).close();
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("Maximum image number reached.");
            throw illegalStateException;
        }
    }

    public ImageProxy acquireNextImage() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mMatchedImageProxies.isEmpty()) {
                return null;
            }
            if (this.mImageProxiesIndex < this.mMatchedImageProxies.size()) {
                ImageProxy imageProxy = this.mMatchedImageProxies;
                int n = this.mImageProxiesIndex;
                this.mImageProxiesIndex = n + 1;
                imageProxy = imageProxy.get(n);
                this.mAcquiredImageProxies.add(imageProxy);
                return imageProxy;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Maximum image number reached.");
            throw illegalStateException;
        }
    }

    public void clearOnImageAvailableListener() {
        Object object = this.mLock;
        synchronized (object) {
            this.mListener = null;
            this.mExecutor = null;
            return;
        }
    }

    public void close() {
        Object object = this.mLock;
        synchronized (object) {
            try {
                if (this.mClosed) {
                    return;
                }
                Object object2 = new ArrayList(this.mMatchedImageProxies);
                object2 = object2.iterator();
                while (true) {
                    if (!object2.hasNext()) {
                        this.mMatchedImageProxies.clear();
                        this.mImageReaderProxy.close();
                        this.mClosed = true;
                        return;
                    }
                    ((ImageProxy)object2.next()).close();
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    CameraCaptureCallback getCameraCaptureCallback() {
        return this.mCameraCaptureCallback;
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

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    void imageIncoming(ImageReaderProxy imageReaderProxy) {
        Object object = this.mLock;
        synchronized (object) {
            int n;
            if (this.mClosed) {
                return;
            }
            int n2 = 0;
            do {
                ImageProxy imageProxy;
                block11: {
                    imageProxy = null;
                    ImageProxy imageProxy2 = imageReaderProxy.acquireNextImage();
                    n = n2;
                    imageProxy = imageProxy2;
                    if (imageProxy2 == null) break block11;
                    n = n2 + 1;
                    {
                        catch (Throwable throwable) {
                            throw throwable;
                        }
                        catch (IllegalStateException illegalStateException) {}
                        {
                            Logger.d((String)TAG, (String)"Failed to acquire next image.", (Throwable)illegalStateException);
                            n = n2;
                            break block11;
                        }
                    }
                    {
                        this.mPendingImages.put(imageProxy2.getImageInfo().getTimestamp(), (Object)imageProxy2);
                        this.matchImages();
                        imageProxy = imageProxy2;
                    }
                }
                if (imageProxy == null) return;
                n2 = n;
            } while (n < imageReaderProxy.getMaxImages());
            return;
        }
    }

    public /* synthetic */ void lambda$enqueueImageProxy$1$MetadataImageReader(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        onImageAvailableListener.onImageAvailable((ImageReaderProxy)this);
    }

    public /* synthetic */ void lambda$new$0$MetadataImageReader(ImageReaderProxy imageReaderProxy) {
        this.imageIncoming(imageReaderProxy);
    }

    public void onImageClose(ImageProxy imageProxy) {
        Object object = this.mLock;
        synchronized (object) {
            this.dequeImageProxy(imageProxy);
            return;
        }
    }

    void resultIncoming(CameraCaptureResult cameraCaptureResult) {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mClosed) {
                return;
            }
            LongSparseArray<ImageInfo> longSparseArray = this.mPendingImageInfos;
            long l = cameraCaptureResult.getTimestamp();
            CameraCaptureResultImageInfo cameraCaptureResultImageInfo = new CameraCaptureResultImageInfo(cameraCaptureResult);
            longSparseArray.put(l, (Object)cameraCaptureResultImageInfo);
            this.matchImages();
            return;
        }
    }

    public void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
        Object object = this.mLock;
        synchronized (object) {
            this.mListener = (ImageReaderProxy.OnImageAvailableListener)Preconditions.checkNotNull((Object)onImageAvailableListener);
            this.mExecutor = (Executor)Preconditions.checkNotNull((Object)executor);
            this.mImageReaderProxy.setOnImageAvailableListener(this.mTransformedListener, executor);
            return;
        }
    }
}
