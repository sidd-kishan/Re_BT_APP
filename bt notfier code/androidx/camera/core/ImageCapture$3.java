/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$OnImageCapturedCallback
 *  androidx.camera.core.ImageCapture$OnImageSavedCallback
 *  androidx.camera.core.ImageCapture$OutputFileOptions
 *  androidx.camera.core.ImageCaptureException
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.ImageSaver
 *  androidx.camera.core.ImageSaver$OnImageSavedCallback
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageSaver;
import java.util.concurrent.Executor;

class ImageCapture.3
extends ImageCapture.OnImageCapturedCallback {
    final ImageCapture this$0;
    final Executor val$executor;
    final ImageCapture.OnImageSavedCallback val$imageSavedCallback;
    final ImageSaver.OnImageSavedCallback val$imageSavedCallbackWrapper;
    final ImageCapture.OutputFileOptions val$outputFileOptions;

    ImageCapture.3(ImageCapture imageCapture, ImageCapture.OutputFileOptions outputFileOptions, Executor executor, ImageSaver.OnImageSavedCallback onImageSavedCallback, ImageCapture.OnImageSavedCallback onImageSavedCallback2) {
        this.this$0 = imageCapture;
        this.val$outputFileOptions = outputFileOptions;
        this.val$executor = executor;
        this.val$imageSavedCallbackWrapper = onImageSavedCallback;
        this.val$imageSavedCallback = onImageSavedCallback2;
    }

    public void onCaptureSuccess(ImageProxy imageProxy) {
        this.this$0.mIoExecutor.execute((Runnable)new ImageSaver(imageProxy, this.val$outputFileOptions, imageProxy.getImageInfo().getRotationDegrees(), this.val$executor, this.this$0.mSequentialIoExecutor, this.val$imageSavedCallbackWrapper));
    }

    public void onError(ImageCaptureException imageCaptureException) {
        this.val$imageSavedCallback.onError(imageCaptureException);
    }
}
