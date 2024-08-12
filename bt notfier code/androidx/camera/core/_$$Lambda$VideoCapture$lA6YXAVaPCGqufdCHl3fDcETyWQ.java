/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.VideoCapture
 *  androidx.camera.core.VideoCapture$OnVideoSavedCallback
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.VideoCapture;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final class _$$Lambda$VideoCapture$lA6YXAVaPCGqufdCHl3fDcETyWQ
implements Runnable {
    private final VideoCapture f$0;
    private final VideoCapture.OnVideoSavedCallback f$1;
    private final String f$2;
    private final Size f$3;
    private final CallbackToFutureAdapter.Completer f$4;

    public /* synthetic */ _$$Lambda$VideoCapture$lA6YXAVaPCGqufdCHl3fDcETyWQ(VideoCapture videoCapture, VideoCapture.OnVideoSavedCallback onVideoSavedCallback, String string, Size size, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = videoCapture;
        this.f$1 = onVideoSavedCallback;
        this.f$2 = string;
        this.f$3 = size;
        this.f$4 = completer;
    }

    @Override
    public final void run() {
        this.f$0.lambda$startRecording$4$VideoCapture(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
