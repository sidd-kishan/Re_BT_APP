/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CaptureProcessorPipeline
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 */
package androidx.camera.core;

import androidx.camera.core.CaptureProcessorPipeline;
import androidx.camera.core.impl.ImageReaderProxy;

class CaptureProcessorPipeline.1
implements ImageReaderProxy.OnImageAvailableListener {
    final CaptureProcessorPipeline this$0;

    CaptureProcessorPipeline.1(CaptureProcessorPipeline captureProcessorPipeline) {
        this.this$0 = captureProcessorPipeline;
    }

    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.this$0.postProcess(imageReaderProxy.acquireNextImage());
    }
}
