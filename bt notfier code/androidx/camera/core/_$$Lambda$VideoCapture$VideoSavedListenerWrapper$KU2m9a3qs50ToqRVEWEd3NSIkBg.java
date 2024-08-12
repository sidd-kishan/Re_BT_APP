/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.VideoCapture$OutputFileResults
 *  androidx.camera.core.VideoCapture$VideoSavedListenerWrapper
 */
package androidx.camera.core;

import androidx.camera.core.VideoCapture;

public final class _$$Lambda$VideoCapture$VideoSavedListenerWrapper$KU2m9a3qs50ToqRVEWEd3NSIkBg
implements Runnable {
    private final VideoCapture.VideoSavedListenerWrapper f$0;
    private final VideoCapture.OutputFileResults f$1;

    public /* synthetic */ _$$Lambda$VideoCapture$VideoSavedListenerWrapper$KU2m9a3qs50ToqRVEWEd3NSIkBg(VideoCapture.VideoSavedListenerWrapper videoSavedListenerWrapper, VideoCapture.OutputFileResults outputFileResults) {
        this.f$0 = videoSavedListenerWrapper;
        this.f$1 = outputFileResults;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onVideoSaved$0$VideoCapture$VideoSavedListenerWrapper(this.f$1);
    }
}
