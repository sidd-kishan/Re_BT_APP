/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.ImageAnalysis
 *  androidx.camera.core.impl.ImageAnalysisConfig
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$ErrorListener
 *  androidx.camera.core.impl.SessionConfig$SessionError
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.SessionConfig;

public final class _$$Lambda$ImageAnalysis$Gd6VUhKl5XOmwdAgw0vhwsuiNpE
implements SessionConfig.ErrorListener {
    private final ImageAnalysis f$0;
    private final String f$1;
    private final ImageAnalysisConfig f$2;
    private final Size f$3;

    public /* synthetic */ _$$Lambda$ImageAnalysis$Gd6VUhKl5XOmwdAgw0vhwsuiNpE(ImageAnalysis imageAnalysis, String string, ImageAnalysisConfig imageAnalysisConfig, Size size) {
        this.f$0 = imageAnalysis;
        this.f$1 = string;
        this.f$2 = imageAnalysisConfig;
        this.f$3 = size;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f$0.lambda$createPipeline$0$ImageAnalysis(this.f$1, this.f$2, this.f$3, sessionConfig, sessionError);
    }
}
