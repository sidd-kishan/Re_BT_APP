/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.view.CameraController
 */
package androidx.camera.view;

import androidx.camera.core.CameraSelector;
import androidx.camera.view.CameraController;

public final class _$$Lambda$CameraController$R5yuSoRWAGX1Z8E19_LL_4Qx0w8
implements Runnable {
    private final CameraController f$0;
    private final CameraSelector f$1;

    public /* synthetic */ _$$Lambda$CameraController$R5yuSoRWAGX1Z8E19_LL_4Qx0w8(CameraController cameraController, CameraSelector cameraSelector) {
        this.f$0 = cameraController;
        this.f$1 = cameraSelector;
    }

    @Override
    public final void run() {
        this.f$0.lambda$setCameraSelector$2$CameraController(this.f$1);
    }
}
