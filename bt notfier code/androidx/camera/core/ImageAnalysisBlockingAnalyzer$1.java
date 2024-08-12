/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageAnalysisBlockingAnalyzer
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysisBlockingAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.futures.FutureCallback;

class ImageAnalysisBlockingAnalyzer.1
implements FutureCallback<Void> {
    final ImageAnalysisBlockingAnalyzer this$0;
    final ImageProxy val$imageProxy;

    ImageAnalysisBlockingAnalyzer.1(ImageAnalysisBlockingAnalyzer imageAnalysisBlockingAnalyzer, ImageProxy imageProxy) {
        this.this$0 = imageAnalysisBlockingAnalyzer;
        this.val$imageProxy = imageProxy;
    }

    public void onFailure(Throwable throwable) {
        this.val$imageProxy.close();
    }

    public void onSuccess(Void void_) {
    }
}
