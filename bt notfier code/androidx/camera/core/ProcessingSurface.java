/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Size
 *  android.view.Surface
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.Logger
 *  androidx.camera.core.MetadataImageReader
 *  androidx.camera.core._$$Lambda$ProcessingSurface$fleJ7Fv2BvhRan9diypF10B_VWk
 *  androidx.camera.core._$$Lambda$ProcessingSurface$g7Iq8eLl8MFZ63JqJ0Kpek7IMD0
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CaptureProcessor
 *  androidx.camera.core.impl.CaptureStage
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.ImageProxyBundle
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 *  androidx.camera.core.impl.SingleImageProxyBundle
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 */
package androidx.camera.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core._$;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.SingleImageProxyBundle;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

final class ProcessingSurface
extends DeferrableSurface {
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "ProcessingSurfaceTextur";
    private final CameraCaptureCallback mCameraCaptureCallback;
    final CaptureProcessor mCaptureProcessor;
    final CaptureStage mCaptureStage;
    private final Handler mImageReaderHandler;
    final MetadataImageReader mInputImageReader;
    final Surface mInputSurface;
    final Object mLock = new Object();
    private final DeferrableSurface mOutputDeferrableSurface;
    boolean mReleased = false;
    private final Size mResolution;
    private String mTagBundleKey;
    private final ImageReaderProxy.OnImageAvailableListener mTransformedListener = new _$.Lambda.ProcessingSurface.g7Iq8eLl8MFZ63JqJ0Kpek7IMD0(this);

    ProcessingSurface(int n, int n2, int n3, Handler handler, CaptureStage captureStage, CaptureProcessor captureProcessor, DeferrableSurface deferrableSurface, String string) {
        this.mResolution = new Size(n, n2);
        if (handler != null) {
            this.mImageReaderHandler = handler;
        } else {
            handler = Looper.myLooper();
            if (handler == null) throw new IllegalStateException("Creating a ProcessingSurface requires a non-null Handler, or be created  on a thread with a Looper.");
            this.mImageReaderHandler = new Handler((Looper)handler);
        }
        ScheduledExecutorService scheduledExecutorService = CameraXExecutors.newHandlerExecutor((Handler)this.mImageReaderHandler);
        handler = new MetadataImageReader(n, n2, n3, 2);
        this.mInputImageReader = handler;
        handler.setOnImageAvailableListener(this.mTransformedListener, (Executor)scheduledExecutorService);
        this.mInputSurface = this.mInputImageReader.getSurface();
        this.mCameraCaptureCallback = this.mInputImageReader.getCameraCaptureCallback();
        this.mCaptureProcessor = captureProcessor;
        captureProcessor.onResolutionUpdate(this.mResolution);
        this.mCaptureStage = captureStage;
        this.mOutputDeferrableSurface = deferrableSurface;
        this.mTagBundleKey = string;
        Futures.addCallback((ListenableFuture)deferrableSurface.getSurface(), (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)CameraXExecutors.directExecutor());
        this.getTerminationFuture().addListener((Runnable)new _$.Lambda.ProcessingSurface.fleJ7Fv2BvhRan9diypF10B_VWk(this), CameraXExecutors.directExecutor());
    }

    public static /* synthetic */ void lambda$fleJ7Fv2BvhRan9diypF10B_VWk(ProcessingSurface processingSurface) {
        processingSurface.release();
    }

    private void release() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mReleased) {
                return;
            }
            this.mInputImageReader.close();
            this.mInputSurface.release();
            this.mOutputDeferrableSurface.close();
            this.mReleased = true;
            return;
        }
    }

    CameraCaptureCallback getCameraCaptureCallback() {
        Object object = this.mLock;
        synchronized (object) {
            if (!this.mReleased) {
                CameraCaptureCallback cameraCaptureCallback = this.mCameraCaptureCallback;
                return cameraCaptureCallback;
            }
            IllegalStateException illegalStateException = new IllegalStateException("ProcessingSurface already released!");
            throw illegalStateException;
        }
    }

    void imageIncoming(ImageReaderProxy imageReaderProxy) {
        if (this.mReleased) {
            return;
        }
        Object object = null;
        try {
            imageReaderProxy = imageReaderProxy.acquireNextImage();
        }
        catch (IllegalStateException illegalStateException) {
            Logger.e((String)TAG, (String)"Failed to acquire next image.", (Throwable)illegalStateException);
            imageReaderProxy = object;
        }
        if (imageReaderProxy == null) {
            return;
        }
        object = imageReaderProxy.getImageInfo();
        if (object == null) {
            imageReaderProxy.close();
            return;
        }
        Integer n = object.getTagBundle().getTag(this.mTagBundleKey);
        if (n == null) {
            imageReaderProxy.close();
            return;
        }
        if (this.mCaptureStage.getId() != n.intValue()) {
            object = new StringBuilder();
            ((StringBuilder)object).append("ImageProxyBundle does not contain this id: ");
            ((StringBuilder)object).append(n);
            Logger.w((String)TAG, (String)((StringBuilder)object).toString());
            imageReaderProxy.close();
        } else {
            imageReaderProxy = new SingleImageProxyBundle((ImageProxy)imageReaderProxy, this.mTagBundleKey);
            this.mCaptureProcessor.process((ImageProxyBundle)imageReaderProxy);
            imageReaderProxy.close();
        }
    }

    public /* synthetic */ void lambda$new$0$ProcessingSurface(ImageReaderProxy imageReaderProxy) {
        Object object = this.mLock;
        synchronized (object) {
            this.imageIncoming(imageReaderProxy);
            return;
        }
    }

    public ListenableFuture<Surface> provideSurface() {
        Object object = this.mLock;
        synchronized (object) {
            ListenableFuture listenableFuture = Futures.immediateFuture((Object)this.mInputSurface);
            return listenableFuture;
        }
    }
}
