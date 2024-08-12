/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.VideoCapture
 *  androidx.camera.core.VideoCapture$OnVideoSavedCallback
 *  androidx.camera.core.VideoCapture$OutputFileOptions
 */
package androidx.camera.core;

import androidx.camera.core.VideoCapture;
import java.util.concurrent.Executor;

public final class _$$Lambda$VideoCapture$CtkdvPm9R_T2rWkFfmPoBN8pCVg
implements Runnable {
    private final VideoCapture f$0;
    private final VideoCapture.OutputFileOptions f$1;
    private final Executor f$2;
    private final VideoCapture.OnVideoSavedCallback f$3;

    public /* synthetic */ _$$Lambda$VideoCapture$CtkdvPm9R_T2rWkFfmPoBN8pCVg(VideoCapture videoCapture, VideoCapture.OutputFileOptions outputFileOptions, Executor executor, VideoCapture.OnVideoSavedCallback onVideoSavedCallback) {
        this.f$0 = videoCapture;
        this.f$1 = outputFileOptions;
        this.f$2 = executor;
        this.f$3 = onVideoSavedCallback;
    }

    @Override
    public final void run() {
        this.f$0.lambda$startRecording$0$VideoCapture(this.f$1, this.f$2, this.f$3);
    }
}
