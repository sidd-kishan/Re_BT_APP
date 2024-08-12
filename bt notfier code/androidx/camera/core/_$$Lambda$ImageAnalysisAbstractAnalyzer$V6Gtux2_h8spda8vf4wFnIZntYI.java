/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageAnalysis$Analyzer
 *  androidx.camera.core.ImageAnalysisAbstractAnalyzer
 *  androidx.camera.core.ImageProxy
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageAnalysisAbstractAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$ImageAnalysisAbstractAnalyzer$V6Gtux2_h8spda8vf4wFnIZntYI
implements Runnable {
    private final ImageAnalysisAbstractAnalyzer f$0;
    private final ImageProxy f$1;
    private final ImageAnalysis.Analyzer f$2;
    private final CallbackToFutureAdapter.Completer f$3;

    public /* synthetic */ _$$Lambda$ImageAnalysisAbstractAnalyzer$V6Gtux2_h8spda8vf4wFnIZntYI(ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = imageAnalysisAbstractAnalyzer;
        this.f$1 = imageProxy;
        this.f$2 = analyzer;
        this.f$3 = completer;
    }

    @Override
    public final void run() {
        this.f$0.lambda$analyzeImage$0$ImageAnalysisAbstractAnalyzer(this.f$1, this.f$2, this.f$3);
    }
}
