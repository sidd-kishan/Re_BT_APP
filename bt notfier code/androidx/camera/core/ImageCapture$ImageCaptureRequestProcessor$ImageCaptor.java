/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture$ImageCaptureRequest
 *  androidx.camera.core.ImageProxy
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import com.google.common.util.concurrent.ListenableFuture;

static interface ImageCapture.ImageCaptureRequestProcessor.ImageCaptor {
    public ListenableFuture<ImageProxy> capture(ImageCapture.ImageCaptureRequest var1);
}
