/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCaptureException
 *  androidx.camera.core.ImageProxy
 */
package androidx.camera.core;

import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;

public static abstract class ImageCapture.OnImageCapturedCallback {
    public void onCaptureSuccess(ImageProxy imageProxy) {
    }

    public void onError(ImageCaptureException imageCaptureException) {
    }
}
