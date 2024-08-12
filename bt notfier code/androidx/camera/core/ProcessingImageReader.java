/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.util.Size
 *  android.view.Surface
 *  androidx.camera.core.AndroidImageReaderProxy
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.Logger
 *  androidx.camera.core.MetadataImageReader
 *  androidx.camera.core.SettableImageProxyBundle
 *  androidx.camera.core._$$Lambda$ProcessingImageReader$qqWgnehxr_h_Iaesle51wu3dB08
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CaptureBundle
 *  androidx.camera.core.impl.CaptureProcessor
 *  androidx.camera.core.impl.CaptureStage
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.AndroidImageReaderProxy;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SettableImageProxyBundle;
import androidx.camera.core._$;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

class ProcessingImageReader
implements ImageReaderProxy {
    private static final String TAG = "ProcessingImageReader";
    private final List<Integer> mCaptureIdList;
    final CaptureProcessor mCaptureProcessor;
    private FutureCallback<List<ImageProxy>> mCaptureStageReadyCallback;
    CallbackToFutureAdapter.Completer<Void> mCloseCompleter;
    private ListenableFuture<Void> mCloseFuture;
    boolean mClosed = false;
    Executor mExecutor;
    private ImageReaderProxy.OnImageAvailableListener mImageProcessedListener;
    final MetadataImageReader mInputImageReader;
    ImageReaderProxy.OnImageAvailableListener mListener;
    final Object mLock = new Object();
    final ImageReaderProxy mOutputImageReader;
    final Executor mPostProcessExecutor;
    boolean mProcessing = false;
    SettableImageProxyBundle mSettableImageProxyBundle;
    private String mTagBundleKey;
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener = new /* Unavailable Anonymous Inner Class!! */;

    ProcessingImageReader(int n, int n2, int n3, int n4, Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor) {
        this(n, n2, n3, n4, executor, captureBundle, captureProcessor, n3);
    }

    ProcessingImageReader(int n, int n2, int n3, int n4, Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor, int n5) {
        this(new MetadataImageReader(n, n2, n3, n4), executor, captureBundle, captureProcessor, n5);
    }

    ProcessingImageReader(MetadataImageReader metadataImageReader, Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor) {
        this(metadataImageReader, executor, captureBundle, captureProcessor, metadataImageReader.getImageFormat());
    }

    ProcessingImageReader(MetadataImageReader metadataImageReader, Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor, int n) {
        this.mImageProcessedListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mCaptureStageReadyCallback = new /* Unavailable Anonymous Inner Class!! */;
        this.mTagBundleKey = new String();
        this.mSettableImageProxyBundle = new SettableImageProxyBundle(Collections.emptyList(), this.mTagBundleKey);
        this.mCaptureIdList = new ArrayList<Integer>();
        if (metadataImageReader.getMaxImages() < captureBundle.getCaptureStages().size()) throw new IllegalArgumentException("MetadataImageReader is smaller than CaptureBundle.");
        this.mInputImageReader = metadataImageReader;
        int n2 = metadataImageReader.getWidth();
        int n3 = metadataImageReader.getHeight();
        if (n == 256) {
            n2 = metadataImageReader.getWidth() * metadataImageReader.getHeight();
            n3 = 1;
        }
        metadataImageReader = new AndroidImageReaderProxy(ImageReader.newInstance((int)n2, (int)n3, (int)n, (int)metadataImageReader.getMaxImages()));
        this.mOutputImageReader = metadataImageReader;
        this.mPostProcessExecutor = executor;
        this.mCaptureProcessor = captureProcessor;
        captureProcessor.onOutputSurface(metadataImageReader.getSurface(), n);
        this.mCaptureProcessor.onResolutionUpdate(new Size(this.mInputImageReader.getWidth(), this.mInputImageReader.getHeight()));
        this.setCaptureBundle(captureBundle);
    }

    public ImageProxy acquireLatestImage() {
        Object object = this.mLock;
        synchronized (object) {
            ImageProxy imageProxy = this.mOutputImageReader.acquireLatestImage();
            return imageProxy;
        }
    }

    public ImageProxy acquireNextImage() {
        Object object = this.mLock;
        synchronized (object) {
            ImageProxy imageProxy = this.mOutputImageReader.acquireNextImage();
            return imageProxy;
        }
    }

    public void clearOnImageAvailableListener() {
        Object object = this.mLock;
        synchronized (object) {
            this.mListener = null;
            this.mExecutor = null;
            this.mInputImageReader.clearOnImageAvailableListener();
            this.mOutputImageReader.clearOnImageAvailableListener();
            if (this.mProcessing) return;
            this.mSettableImageProxyBundle.close();
            return;
        }
    }

    public void close() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mClosed) {
                return;
            }
            this.mOutputImageReader.clearOnImageAvailableListener();
            if (!this.mProcessing) {
                this.mInputImageReader.close();
                this.mSettableImageProxyBundle.close();
                this.mOutputImageReader.close();
                if (this.mCloseCompleter != null) {
                    this.mCloseCompleter.set(null);
                }
            }
            this.mClosed = true;
            return;
        }
    }

    CameraCaptureCallback getCameraCaptureCallback() {
        Object object = this.mLock;
        synchronized (object) {
            CameraCaptureCallback cameraCaptureCallback = this.mInputImageReader.getCameraCaptureCallback();
            return cameraCaptureCallback;
        }
    }

    ListenableFuture<Void> getCloseFuture() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2;
            if (this.mClosed && !this.mProcessing) {
                object2 = Futures.immediateFuture(null);
            } else {
                if (this.mCloseFuture == null) {
                    object2 = new _$.Lambda.ProcessingImageReader.qqWgnehxr_h_Iaesle51wu3dB08(this);
                    this.mCloseFuture = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)object2);
                }
                object2 = Futures.nonCancellationPropagating(this.mCloseFuture);
            }
            return object2;
        }
    }

    public int getHeight() {
        Object object = this.mLock;
        synchronized (object) {
            int n = this.mInputImageReader.getHeight();
            return n;
        }
    }

    public int getImageFormat() {
        Object object = this.mLock;
        synchronized (object) {
            int n = this.mOutputImageReader.getImageFormat();
            return n;
        }
    }

    public int getMaxImages() {
        Object object = this.mLock;
        synchronized (object) {
            int n = this.mInputImageReader.getMaxImages();
            return n;
        }
    }

    public Surface getSurface() {
        Object object = this.mLock;
        synchronized (object) {
            Surface surface = this.mInputImageReader.getSurface();
            return surface;
        }
    }

    public String getTagBundleKey() {
        return this.mTagBundleKey;
    }

    public int getWidth() {
        Object object = this.mLock;
        synchronized (object) {
            int n = this.mInputImageReader.getWidth();
            return n;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    void imageIncoming(ImageReaderProxy object) {
        Object object2 = this.mLock;
        // MONITORENTER : object2
        if (this.mClosed) {
            // MONITOREXIT : object2
            return;
        }
        ImageProxy imageProxy = object.acquireNextImage();
        if (imageProxy == null) return;
        object = imageProxy.getImageInfo().getTagBundle().getTag(this.mTagBundleKey);
        if (!this.mCaptureIdList.contains(object)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ImageProxyBundle does not contain this id: ");
            stringBuilder.append(object);
            Logger.w((String)TAG, (String)stringBuilder.toString());
            imageProxy.close();
            return;
        }
        this.mSettableImageProxyBundle.addImageProxy(imageProxy);
        return;
        {
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (IllegalStateException illegalStateException) {}
            {
                Logger.e((String)TAG, (String)"Failed to acquire latest image.", (Throwable)illegalStateException);
                // MONITOREXIT : object2
                return;
            }
        }
    }

    public /* synthetic */ Object lambda$getCloseFuture$0$ProcessingImageReader(CallbackToFutureAdapter.Completer completer) throws Exception {
        Object object = this.mLock;
        synchronized (object) {
            this.mCloseCompleter = completer;
            return "ProcessingImageReader-close";
        }
    }

    public void setCaptureBundle(CaptureBundle object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            try {
                if (object.getCaptureStages() != null) {
                    if (this.mInputImageReader.getMaxImages() < object.getCaptureStages().size()) {
                        object = new IllegalArgumentException("CaptureBundle is larger than InputImageReader.");
                        throw object;
                    }
                    this.mCaptureIdList.clear();
                    for (CaptureStage captureStage : object.getCaptureStages()) {
                        if (captureStage == null) continue;
                        this.mCaptureIdList.add(captureStage.getId());
                    }
                }
                object = Integer.toString(object.hashCode());
                this.mTagBundleKey = object;
                Object object3 = new SettableImageProxyBundle(this.mCaptureIdList, (String)object);
                this.mSettableImageProxyBundle = object3;
                this.setupSettableImageProxyBundleCallbacks();
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
        Object object = this.mLock;
        synchronized (object) {
            this.mListener = (ImageReaderProxy.OnImageAvailableListener)Preconditions.checkNotNull((Object)onImageAvailableListener);
            this.mExecutor = (Executor)Preconditions.checkNotNull((Object)executor);
            this.mInputImageReader.setOnImageAvailableListener(this.mTransformedListener, executor);
            this.mOutputImageReader.setOnImageAvailableListener(this.mImageProcessedListener, executor);
            return;
        }
    }

    void setupSettableImageProxyBundleCallbacks() {
        ArrayList<ListenableFuture> arrayList = new ArrayList<ListenableFuture>();
        Iterator<Integer> iterator = this.mCaptureIdList.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                Futures.addCallback((ListenableFuture)Futures.allAsList(arrayList), this.mCaptureStageReadyCallback, (Executor)this.mPostProcessExecutor);
                return;
            }
            Integer n = iterator.next();
            arrayList.add(this.mSettableImageProxyBundle.getImageProxy(n.intValue()));
        }
    }
}
