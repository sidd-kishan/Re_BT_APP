/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ForwardingImageProxy$OnImageCloseListener
 *  androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy
 *  androidx.camera.core.ImageProxy
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;
import androidx.camera.core.ImageProxy;

public final class _$$Lambda$ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy$Pq3gquMkypA8mh_f3dMKr3oV0M8
implements ForwardingImageProxy.OnImageCloseListener {
    private final ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy f$0;

    public /* synthetic */ _$$Lambda$ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy$Pq3gquMkypA8mh_f3dMKr3oV0M8(ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy cacheAnalyzingImageProxy) {
        this.f$0 = cacheAnalyzingImageProxy;
    }

    public final void onImageClose(ImageProxy imageProxy) {
        this.f$0.lambda$new$0$ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy(imageProxy);
    }
}
