/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.VideoCapture$VideoSavedListenerWrapper
 */
package androidx.camera.core;

import androidx.camera.core.VideoCapture;

public final class _$$Lambda$VideoCapture$VideoSavedListenerWrapper$ZG5otqrkESy2VwQvd4RLRJQ1fFY
implements Runnable {
    private final VideoCapture.VideoSavedListenerWrapper f$0;
    private final int f$1;
    private final String f$2;
    private final Throwable f$3;

    public /* synthetic */ _$$Lambda$VideoCapture$VideoSavedListenerWrapper$ZG5otqrkESy2VwQvd4RLRJQ1fFY(VideoCapture.VideoSavedListenerWrapper videoSavedListenerWrapper, int n, String string, Throwable throwable) {
        this.f$0 = videoSavedListenerWrapper;
        this.f$1 = n;
        this.f$2 = string;
        this.f$3 = throwable;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onError$1$VideoCapture$VideoSavedListenerWrapper(this.f$1, this.f$2, this.f$3);
    }
}
