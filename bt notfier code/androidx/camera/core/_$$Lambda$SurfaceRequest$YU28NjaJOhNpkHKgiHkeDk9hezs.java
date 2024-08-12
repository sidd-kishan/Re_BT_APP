/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.core.SurfaceRequest$TransformationInfo
 *  androidx.camera.core.SurfaceRequest$TransformationInfoListener
 */
package androidx.camera.core;

import androidx.camera.core.SurfaceRequest;

public final class _$$Lambda$SurfaceRequest$YU28NjaJOhNpkHKgiHkeDk9hezs
implements Runnable {
    private final SurfaceRequest.TransformationInfoListener f$0;
    private final SurfaceRequest.TransformationInfo f$1;

    public /* synthetic */ _$$Lambda$SurfaceRequest$YU28NjaJOhNpkHKgiHkeDk9hezs(SurfaceRequest.TransformationInfoListener transformationInfoListener, SurfaceRequest.TransformationInfo transformationInfo) {
        this.f$0 = transformationInfoListener;
        this.f$1 = transformationInfo;
    }

    @Override
    public final void run() {
        SurfaceRequest.lambda$updateTransformationInfo$6((SurfaceRequest.TransformationInfoListener)this.f$0, (SurfaceRequest.TransformationInfo)this.f$1);
    }
}
