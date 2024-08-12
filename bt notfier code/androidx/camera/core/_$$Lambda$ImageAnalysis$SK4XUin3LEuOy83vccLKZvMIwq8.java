/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageAnalysis
 *  androidx.camera.core.ImageAnalysis$Analyzer
 *  androidx.camera.core.ImageProxy
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;

public final class _$$Lambda$ImageAnalysis$SK4XUin3LEuOy83vccLKZvMIwq8
implements ImageAnalysis.Analyzer {
    private final ImageAnalysis f$0;
    private final ImageAnalysis.Analyzer f$1;

    public /* synthetic */ _$$Lambda$ImageAnalysis$SK4XUin3LEuOy83vccLKZvMIwq8(ImageAnalysis imageAnalysis, ImageAnalysis.Analyzer analyzer) {
        this.f$0 = imageAnalysis;
        this.f$1 = analyzer;
    }

    public final void analyze(ImageProxy imageProxy) {
        this.f$0.lambda$setAnalyzer$1$ImageAnalysis(this.f$1, imageProxy);
    }
}
