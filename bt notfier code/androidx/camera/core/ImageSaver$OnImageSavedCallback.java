/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture$OutputFileResults
 *  androidx.camera.core.ImageSaver$SaveError
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageSaver;

public static interface ImageSaver.OnImageSavedCallback {
    public void onError(ImageSaver.SaveError var1, String var2, Throwable var3);

    public void onImageSaved(ImageCapture.OutputFileResults var1);
}
