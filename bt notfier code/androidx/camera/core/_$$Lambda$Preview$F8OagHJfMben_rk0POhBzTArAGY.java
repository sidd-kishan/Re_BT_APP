/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Preview
 *  androidx.camera.core.Preview$SurfaceProvider
 *  androidx.camera.core.SurfaceRequest
 */
package androidx.camera.core;

import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;

public final class _$$Lambda$Preview$F8OagHJfMben_rk0POhBzTArAGY
implements Runnable {
    private final Preview.SurfaceProvider f$0;
    private final SurfaceRequest f$1;

    public /* synthetic */ _$$Lambda$Preview$F8OagHJfMben_rk0POhBzTArAGY(Preview.SurfaceProvider surfaceProvider, SurfaceRequest surfaceRequest) {
        this.f$0 = surfaceProvider;
        this.f$1 = surfaceRequest;
    }

    @Override
    public final void run() {
        Preview.lambda$sendSurfaceRequestIfReady$1((Preview.SurfaceProvider)this.f$0, (SurfaceRequest)this.f$1);
    }
}
