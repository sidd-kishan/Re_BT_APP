/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageAnalysisNonBlockingAnalyzer
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;

public final class _$$Lambda$XqijcvI3c7o9krbxaHVHifcwgaY
implements Runnable {
    private final ImageAnalysisNonBlockingAnalyzer f$0;

    public /* synthetic */ _$$Lambda$XqijcvI3c7o9krbxaHVHifcwgaY(ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer) {
        this.f$0 = imageAnalysisNonBlockingAnalyzer;
    }

    @Override
    public final void run() {
        this.f$0.analyzeCachedImage();
    }
}
