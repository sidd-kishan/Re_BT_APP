/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ForwardingImageProxy$OnImageCloseListener
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$ImageCaptureRequest
 *  androidx.camera.core.ImageCapture$ImageCaptureRequestProcessor
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.SingleCloseImageProxy
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SingleCloseImageProxy;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.core.util.Preconditions;
import java.util.concurrent.CancellationException;

/*
 * Exception performing whole class analysis ignored.
 */
class ImageCapture.ImageCaptureRequestProcessor.1
implements FutureCallback<ImageProxy> {
    final ImageCapture.ImageCaptureRequestProcessor this$0;
    final ImageCapture.ImageCaptureRequest val$imageCaptureRequest;

    ImageCapture.ImageCaptureRequestProcessor.1(ImageCapture.ImageCaptureRequestProcessor imageCaptureRequestProcessor, ImageCapture.ImageCaptureRequest imageCaptureRequest) {
        this.this$0 = imageCaptureRequestProcessor;
        this.val$imageCaptureRequest = imageCaptureRequest;
    }

    public void onFailure(Throwable throwable) {
        Object object = this.this$0.mLock;
        synchronized (object) {
            if (!(throwable instanceof CancellationException)) {
                ImageCapture.ImageCaptureRequest imageCaptureRequest = this.val$imageCaptureRequest;
                int n = ImageCapture.getError((Throwable)throwable);
                String string = throwable != null ? throwable.getMessage() : "Unknown error";
                imageCaptureRequest.notifyCallbackError(n, string, throwable);
            }
            this.this$0.mCurrentRequest = null;
            this.this$0.mCurrentRequestFuture = null;
            this.this$0.processNextRequest();
            return;
        }
    }

    public void onSuccess(ImageProxy imageProxy) {
        Object object = this.this$0.mLock;
        synchronized (object) {
            Preconditions.checkNotNull((Object)imageProxy);
            SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(imageProxy);
            singleCloseImageProxy.addOnImageCloseListener((ForwardingImageProxy.OnImageCloseListener)this.this$0);
            imageProxy = this.this$0;
            ++imageProxy.mOutstandingImages;
            this.val$imageCaptureRequest.dispatchImage((ImageProxy)singleCloseImageProxy);
            this.this$0.mCurrentRequest = null;
            this.this$0.mCurrentRequestFuture = null;
            this.this$0.processNextRequest();
            return;
        }
    }
}
