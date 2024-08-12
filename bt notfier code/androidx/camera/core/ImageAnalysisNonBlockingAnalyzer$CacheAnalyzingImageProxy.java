/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ForwardingImageProxy
 *  androidx.camera.core.ForwardingImageProxy$OnImageCloseListener
 *  androidx.camera.core.ImageAnalysisNonBlockingAnalyzer
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core._$$Lambda$ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy$Pq3gquMkypA8mh_f3dMKr3oV0M8
 *  androidx.camera.core._$$Lambda$XqijcvI3c7o9krbxaHVHifcwgaY
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.camera.core._$;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Executor;

static class ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy
extends ForwardingImageProxy {
    final WeakReference<ImageAnalysisNonBlockingAnalyzer> mNonBlockingAnalyzerWeakReference;

    ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy(ImageProxy imageProxy, ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer) {
        super(imageProxy);
        this.mNonBlockingAnalyzerWeakReference = new WeakReference<ImageAnalysisNonBlockingAnalyzer>(imageAnalysisNonBlockingAnalyzer);
        this.addOnImageCloseListener((ForwardingImageProxy.OnImageCloseListener)new _$.Lambda.ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy.Pq3gquMkypA8mh_f3dMKr3oV0M8(this));
    }

    public /* synthetic */ void lambda$new$0$ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy(ImageProxy imageProxy) {
        imageProxy = (ImageAnalysisNonBlockingAnalyzer)this.mNonBlockingAnalyzerWeakReference.get();
        if (imageProxy == null) return;
        Executor executor = imageProxy.mBackgroundExecutor;
        Objects.requireNonNull(imageProxy);
        executor.execute((Runnable)new _$.Lambda.XqijcvI3c7o9krbxaHVHifcwgaY((ImageAnalysisNonBlockingAnalyzer)imageProxy));
    }
}
