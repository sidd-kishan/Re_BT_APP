/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageAnalysisNonBlockingAnalyzer
 *  androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;
import androidx.camera.core.impl.utils.futures.FutureCallback;

class ImageAnalysisNonBlockingAnalyzer.1
implements FutureCallback<Void> {
    final ImageAnalysisNonBlockingAnalyzer this$0;
    final ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy val$newPostedImage;

    ImageAnalysisNonBlockingAnalyzer.1(ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer, ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy cacheAnalyzingImageProxy) {
        this.this$0 = imageAnalysisNonBlockingAnalyzer;
        this.val$newPostedImage = cacheAnalyzingImageProxy;
    }

    public void onFailure(Throwable throwable) {
        this.val$newPostedImage.close();
    }

    public void onSuccess(Void void_) {
    }
}
