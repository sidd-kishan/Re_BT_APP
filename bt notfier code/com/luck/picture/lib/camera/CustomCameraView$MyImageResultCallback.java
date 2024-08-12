/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView
 *  androidx.camera.core.ImageCapture$OnImageSavedCallback
 *  androidx.camera.core.ImageCapture$OutputFileResults
 *  androidx.camera.core.ImageCaptureException
 *  com.luck.picture.lib.camera.listener.CameraListener
 *  com.luck.picture.lib.camera.listener.ImageCallbackListener
 *  com.luck.picture.lib.camera.view.CaptureLayout
 */
package com.luck.picture.lib.camera;

import android.widget.ImageView;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import com.luck.picture.lib.camera.listener.CameraListener;
import com.luck.picture.lib.camera.listener.ImageCallbackListener;
import com.luck.picture.lib.camera.view.CaptureLayout;
import java.io.File;
import java.lang.ref.WeakReference;

private static class CustomCameraView.MyImageResultCallback
implements ImageCapture.OnImageSavedCallback {
    private final WeakReference<CameraListener> mCameraListenerReference;
    private final WeakReference<CaptureLayout> mCaptureLayoutReference;
    private final WeakReference<File> mFileReference;
    private final WeakReference<ImageCallbackListener> mImageCallbackListenerReference;
    private final WeakReference<ImageView> mImagePreviewReference;

    public CustomCameraView.MyImageResultCallback(File file, ImageView imageView, CaptureLayout captureLayout, ImageCallbackListener imageCallbackListener, CameraListener cameraListener) {
        this.mFileReference = new WeakReference<File>(file);
        this.mImagePreviewReference = new WeakReference<ImageView>(imageView);
        this.mCaptureLayoutReference = new WeakReference<CaptureLayout>(captureLayout);
        this.mImageCallbackListenerReference = new WeakReference<ImageCallbackListener>(imageCallbackListener);
        this.mCameraListenerReference = new WeakReference<CameraListener>(cameraListener);
    }

    public void onError(ImageCaptureException imageCaptureException) {
        if (this.mCaptureLayoutReference.get() != null) {
            ((CaptureLayout)this.mCaptureLayoutReference.get()).setButtonCaptureEnabled(true);
        }
        if (this.mCameraListenerReference.get() == null) return;
        ((CameraListener)this.mCameraListenerReference.get()).onError(imageCaptureException.getImageCaptureError(), imageCaptureException.getMessage(), imageCaptureException.getCause());
    }

    public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
        if (this.mCaptureLayoutReference.get() != null) {
            ((CaptureLayout)this.mCaptureLayoutReference.get()).setButtonCaptureEnabled(true);
        }
        if (this.mImageCallbackListenerReference.get() != null && this.mFileReference.get() != null && this.mImagePreviewReference.get() != null) {
            ((ImageCallbackListener)this.mImageCallbackListenerReference.get()).onLoadImage((File)this.mFileReference.get(), (ImageView)this.mImagePreviewReference.get());
        }
        if (this.mImagePreviewReference.get() != null) {
            ((ImageView)this.mImagePreviewReference.get()).setVisibility(0);
        }
        if (this.mCaptureLayoutReference.get() == null) return;
        ((CaptureLayout)this.mCaptureLayoutReference.get()).startTypeBtnAnimator();
    }
}
