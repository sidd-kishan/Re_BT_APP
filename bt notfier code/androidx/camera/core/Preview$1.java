/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageInfo
 *  androidx.camera.core.Preview
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.camera.core.impl.ImageInfoProcessor
 *  androidx.camera.core.internal.CameraCaptureResultImageInfo
 */
package androidx.camera.core;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.ImageInfoProcessor;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;

class Preview.1
extends CameraCaptureCallback {
    final Preview this$0;
    final ImageInfoProcessor val$processor;

    Preview.1(Preview preview, ImageInfoProcessor imageInfoProcessor) {
        this.this$0 = preview;
        this.val$processor = imageInfoProcessor;
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        super.onCaptureCompleted(cameraCaptureResult);
        if (!this.val$processor.process((ImageInfo)new CameraCaptureResultImageInfo(cameraCaptureResult))) return;
        this.this$0.notifyUpdated();
    }
}
