/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.impl.ImageCaptureConfig
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$ErrorListener
 *  androidx.camera.core.impl.SessionConfig$SessionError
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.SessionConfig;

public final class _$$Lambda$ImageCapture$krFF_M7LPhv7YZAVeh738KTXgGg
implements SessionConfig.ErrorListener {
    private final ImageCapture f$0;
    private final String f$1;
    private final ImageCaptureConfig f$2;
    private final Size f$3;

    public /* synthetic */ _$$Lambda$ImageCapture$krFF_M7LPhv7YZAVeh738KTXgGg(ImageCapture imageCapture, String string, ImageCaptureConfig imageCaptureConfig, Size size) {
        this.f$0 = imageCapture;
        this.f$1 = string;
        this.f$2 = imageCaptureConfig;
        this.f$3 = size;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f$0.lambda$createPipeline$3$ImageCapture(this.f$1, this.f$2, this.f$3, sessionConfig, sessionError);
    }
}
