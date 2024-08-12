/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageAnalysis$Analyzer
 *  androidx.camera.core.ImageAnalysisAbstractAnalyzer
 *  androidx.camera.core.ImageProxy
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageAnalysisAbstractAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final class _$$Lambda$ImageAnalysisAbstractAnalyzer$mR2LN44DwXC209Sm8_KLIHvFCIo
implements CallbackToFutureAdapter.Resolver {
    private final ImageAnalysisAbstractAnalyzer f$0;
    private final Executor f$1;
    private final ImageProxy f$2;
    private final ImageAnalysis.Analyzer f$3;

    public /* synthetic */ _$$Lambda$ImageAnalysisAbstractAnalyzer$mR2LN44DwXC209Sm8_KLIHvFCIo(ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, Executor executor, ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer) {
        this.f$0 = imageAnalysisAbstractAnalyzer;
        this.f$1 = executor;
        this.f$2 = imageProxy;
        this.f$3 = analyzer;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$analyzeImage$1$ImageAnalysisAbstractAnalyzer(this.f$1, this.f$2, this.f$3, completer);
    }
}
