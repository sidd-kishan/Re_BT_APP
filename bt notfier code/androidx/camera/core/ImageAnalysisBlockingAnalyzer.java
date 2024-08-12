/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageAnalysisAbstractAnalyzer
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysisAbstractAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

final class ImageAnalysisBlockingAnalyzer
extends ImageAnalysisAbstractAnalyzer {
    ImageAnalysisBlockingAnalyzer() {
    }

    ImageProxy acquireImage(ImageReaderProxy imageReaderProxy) {
        return imageReaderProxy.acquireNextImage();
    }

    void clearCache() {
    }

    void onValidImageAvailable(ImageProxy imageProxy) {
        Futures.addCallback((ListenableFuture)this.analyzeImage(imageProxy), (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)CameraXExecutors.directExecutor());
    }
}
