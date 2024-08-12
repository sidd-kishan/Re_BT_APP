/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CaptureProcessorPipeline
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.internal.YuvToJpegProcessor
 */
package androidx.camera.core;

import androidx.camera.core.CaptureProcessorPipeline;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.internal.YuvToJpegProcessor;

public final class _$$Lambda$ImageCapture$GeHlALlHFv1WxWIIQxPTXHlEbSo
implements Runnable {
    private final YuvToJpegProcessor f$0;
    private final CaptureProcessorPipeline f$1;

    public /* synthetic */ _$$Lambda$ImageCapture$GeHlALlHFv1WxWIIQxPTXHlEbSo(YuvToJpegProcessor yuvToJpegProcessor, CaptureProcessorPipeline captureProcessorPipeline) {
        this.f$0 = yuvToJpegProcessor;
        this.f$1 = captureProcessorPipeline;
    }

    @Override
    public final void run() {
        ImageCapture.lambda$createPipeline$1((YuvToJpegProcessor)this.f$0, (CaptureProcessorPipeline)this.f$1);
    }
}
