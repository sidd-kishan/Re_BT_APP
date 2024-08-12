/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.SurfaceRequest$Result
 *  androidx.camera.view.SurfaceViewImplementation$SurfaceRequestCallback
 *  androidx.core.util.Consumer
 */
package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.core.util.Consumer;

public final class _$$Lambda$SurfaceViewImplementation$SurfaceRequestCallback$81WMgLrawbdolK1M9hchPAqvUhI
implements Consumer {
    private final SurfaceViewImplementation.SurfaceRequestCallback f$0;

    public /* synthetic */ _$$Lambda$SurfaceViewImplementation$SurfaceRequestCallback$81WMgLrawbdolK1M9hchPAqvUhI(SurfaceViewImplementation.SurfaceRequestCallback surfaceRequestCallback) {
        this.f$0 = surfaceRequestCallback;
    }

    public final void accept(Object object) {
        this.f$0.lambda$tryToComplete$0$SurfaceViewImplementation$SurfaceRequestCallback((SurfaceRequest.Result)object);
    }
}
