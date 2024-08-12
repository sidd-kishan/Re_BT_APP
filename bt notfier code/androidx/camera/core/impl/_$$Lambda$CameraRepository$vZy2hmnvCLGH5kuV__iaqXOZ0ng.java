/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl.CameraRepository
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;

public final class _$$Lambda$CameraRepository$vZy2hmnvCLGH5kuV__iaqXOZ0ng
implements Runnable {
    private final CameraRepository f$0;
    private final CameraInternal f$1;

    public /* synthetic */ _$$Lambda$CameraRepository$vZy2hmnvCLGH5kuV__iaqXOZ0ng(CameraRepository cameraRepository, CameraInternal cameraInternal) {
        this.f$0 = cameraRepository;
        this.f$1 = cameraInternal;
    }

    @Override
    public final void run() {
        this.f$0.lambda$deinit$1$CameraRepository(this.f$1);
    }
}
