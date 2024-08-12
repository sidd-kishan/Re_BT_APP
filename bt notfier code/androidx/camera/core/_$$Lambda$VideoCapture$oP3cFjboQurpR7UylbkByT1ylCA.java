/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.VideoCapture
 *  androidx.camera.core.VideoCapture$OnVideoSavedCallback
 */
package androidx.camera.core;

import androidx.camera.core.VideoCapture;

public final class _$$Lambda$VideoCapture$oP3cFjboQurpR7UylbkByT1ylCA
implements Runnable {
    private final VideoCapture f$0;
    private final VideoCapture.OnVideoSavedCallback f$1;

    public /* synthetic */ _$$Lambda$VideoCapture$oP3cFjboQurpR7UylbkByT1ylCA(VideoCapture videoCapture, VideoCapture.OnVideoSavedCallback onVideoSavedCallback) {
        this.f$0 = videoCapture;
        this.f$1 = onVideoSavedCallback;
    }

    @Override
    public final void run() {
        this.f$0.lambda$startRecording$3$VideoCapture(this.f$1);
    }
}
