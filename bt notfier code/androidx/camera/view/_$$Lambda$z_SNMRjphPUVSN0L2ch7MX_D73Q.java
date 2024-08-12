/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.view.SurfaceViewImplementation
 */
package androidx.camera.view;

import androidx.camera.view.SurfaceViewImplementation;

public final class _$$Lambda$z_SNMRjphPUVSN0L2ch7MX_D73Q
implements Runnable {
    private final SurfaceViewImplementation f$0;

    public /* synthetic */ _$$Lambda$z_SNMRjphPUVSN0L2ch7MX_D73Q(SurfaceViewImplementation surfaceViewImplementation) {
        this.f$0 = surfaceViewImplementation;
    }

    @Override
    public final void run() {
        this.f$0.notifySurfaceNotInUse();
    }
}
