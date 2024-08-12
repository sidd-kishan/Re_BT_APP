/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.view.SurfaceViewImplementation
 */
package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.SurfaceViewImplementation;

public final class _$$Lambda$SurfaceViewImplementation$AfczykelZ3G5A9yZzYzRueR5eGc
implements Runnable {
    private final SurfaceViewImplementation f$0;
    private final SurfaceRequest f$1;

    public /* synthetic */ _$$Lambda$SurfaceViewImplementation$AfczykelZ3G5A9yZzYzRueR5eGc(SurfaceViewImplementation surfaceViewImplementation, SurfaceRequest surfaceRequest) {
        this.f$0 = surfaceViewImplementation;
        this.f$1 = surfaceRequest;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onSurfaceRequested$0$SurfaceViewImplementation(this.f$1);
    }
}
