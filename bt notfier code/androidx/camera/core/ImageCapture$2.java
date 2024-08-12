/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$9
 *  androidx.camera.core.ImageCapture$OnImageSavedCallback
 *  androidx.camera.core.ImageCapture$OutputFileResults
 *  androidx.camera.core.ImageCaptureException
 *  androidx.camera.core.ImageSaver$OnImageSavedCallback
 *  androidx.camera.core.ImageSaver$SaveError
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageSaver;

class ImageCapture.2
implements ImageSaver.OnImageSavedCallback {
    final ImageCapture this$0;
    final ImageCapture.OnImageSavedCallback val$imageSavedCallback;

    ImageCapture.2(ImageCapture imageCapture, ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        this.this$0 = imageCapture;
        this.val$imageSavedCallback = onImageSavedCallback;
    }

    public void onError(ImageSaver.SaveError saveError, String string, Throwable throwable) {
        int n = ImageCapture.9.$SwitchMap$androidx$camera$core$ImageSaver$SaveError[saveError.ordinal()];
        int n2 = 1;
        if (n != 1) {
            n2 = 0;
        }
        this.val$imageSavedCallback.onError(new ImageCaptureException(n2, string, throwable));
    }

    public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
        this.val$imageSavedCallback.onImageSaved(outputFileResults);
    }
}
