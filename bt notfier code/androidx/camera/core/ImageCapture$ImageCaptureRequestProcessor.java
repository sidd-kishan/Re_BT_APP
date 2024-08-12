/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ForwardingImageProxy$OnImageCloseListener
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$ImageCaptureRequest
 *  androidx.camera.core.ImageCapture$ImageCaptureRequestProcessor$1
 *  androidx.camera.core.ImageCapture$ImageCaptureRequestProcessor$ImageCaptor
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis ignored.
 */
static class ImageCapture.ImageCaptureRequestProcessor
implements ForwardingImageProxy.OnImageCloseListener {
    ImageCapture.ImageCaptureRequest mCurrentRequest = null;
    ListenableFuture<ImageProxy> mCurrentRequestFuture = null;
    private final ImageCaptor mImageCaptor;
    final Object mLock;
    private final int mMaxImages;
    int mOutstandingImages = 0;
    private final Deque<ImageCapture.ImageCaptureRequest> mPendingRequests = new ArrayDeque<ImageCapture.ImageCaptureRequest>();

    ImageCapture.ImageCaptureRequestProcessor(int n, ImageCaptor imageCaptor) {
        this.mLock = new Object();
        this.mMaxImages = n;
        this.mImageCaptor = imageCaptor;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void cancelRequests(Throwable throwable) {
        ArrayList<ImageCapture.ImageCaptureRequest> arrayList;
        Iterator iterator;
        block5: {
            ListenableFuture<ImageProxy> listenableFuture;
            ImageCapture.ImageCaptureRequest imageCaptureRequest;
            iterator = this.mLock;
            synchronized (iterator) {
                imageCaptureRequest = this.mCurrentRequest;
                this.mCurrentRequest = null;
                listenableFuture = this.mCurrentRequestFuture;
                this.mCurrentRequestFuture = null;
                arrayList = new ArrayList<ImageCapture.ImageCaptureRequest>(this.mPendingRequests);
                this.mPendingRequests.clear();
                // MONITOREXIT @DISABLED, blocks:[0, 2] lbl10 : MonitorExitStatement: MONITOREXIT : var2_3
                if (imageCaptureRequest == null || listenableFuture == null) break block5;
                {
                    catch (Throwable throwable2) {}
                    {
                        throw throwable2;
                    }
                }
            }
            imageCaptureRequest.notifyCallbackError(ImageCapture.getError((Throwable)throwable), throwable.getMessage(), throwable);
            listenableFuture.cancel(true);
        }
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((ImageCapture.ImageCaptureRequest)iterator.next()).notifyCallbackError(ImageCapture.getError((Throwable)throwable), throwable.getMessage(), throwable);
        }
    }

    public void onImageClose(ImageProxy imageProxy) {
        Object object = this.mLock;
        synchronized (object) {
            --this.mOutstandingImages;
            this.processNextRequest();
            return;
        }
    }

    void processNextRequest() {
        Object object = this.mLock;
        synchronized (object) {
            ListenableFuture listenableFuture;
            if (this.mCurrentRequest != null) {
                return;
            }
            if (this.mOutstandingImages >= this.mMaxImages) {
                Logger.w((String)"ImageCapture", (String)"Too many acquire images. Close image to be able to process next.");
                return;
            }
            ImageCapture.ImageCaptureRequest imageCaptureRequest = this.mPendingRequests.poll();
            if (imageCaptureRequest == null) {
                return;
            }
            this.mCurrentRequest = imageCaptureRequest;
            this.mCurrentRequestFuture = listenableFuture = this.mImageCaptor.capture(imageCaptureRequest);
            1 var3_5 = new /* Unavailable Anonymous Inner Class!! */;
            Futures.addCallback((ListenableFuture)listenableFuture, (FutureCallback)var3_5, (Executor)CameraXExecutors.directExecutor());
            return;
        }
    }

    public void sendRequest(ImageCapture.ImageCaptureRequest object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            this.mPendingRequests.offer((ImageCapture.ImageCaptureRequest)object);
            object = Locale.US;
            int n = this.mCurrentRequest != null ? 1 : 0;
            Logger.d((String)"ImageCapture", (String)String.format((Locale)object, "Send image capture request [current, pending] = [%d, %d]", n, this.mPendingRequests.size()));
            this.processNextRequest();
            return;
        }
    }
}
