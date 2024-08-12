/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.view.CameraController
 */
package androidx.camera.view;

import androidx.camera.view.CameraController;

public final class _$$Lambda$CameraController$2dQ_Gy8ZeNh5laRN69rrAYUolQg
implements Runnable {
    private final CameraController f$0;
    private final int f$1;

    public /* synthetic */ _$$Lambda$CameraController$2dQ_Gy8ZeNh5laRN69rrAYUolQg(CameraController cameraController, int n) {
        this.f$0 = cameraController;
        this.f$1 = n;
    }

    @Override
    public final void run() {
        this.f$0.lambda$setEnabledUseCases$1$CameraController(this.f$1);
    }
}
