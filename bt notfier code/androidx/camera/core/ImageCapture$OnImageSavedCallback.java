/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture$OutputFileResults
 *  androidx.camera.core.ImageCaptureException
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;

public static interface ImageCapture.OnImageSavedCallback {
    public void onError(ImageCaptureException var1);

    public void onImageSaved(ImageCapture.OutputFileResults var1);
}
