/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.core.SurfaceRequest$TransformationInfo
 *  androidx.camera.core.SurfaceRequest$TransformationInfoListener
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.view.PreviewView$1
 */
package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.view.PreviewView;

public final class _$$Lambda$PreviewView$1$dkzZ5Z1dLMlKv674CZMfvlMrNGM
implements SurfaceRequest.TransformationInfoListener {
    private final PreviewView.1 f$0;
    private final CameraInternal f$1;
    private final SurfaceRequest f$2;

    public /* synthetic */ _$$Lambda$PreviewView$1$dkzZ5Z1dLMlKv674CZMfvlMrNGM(PreviewView.1 var1_1, CameraInternal cameraInternal, SurfaceRequest surfaceRequest) {
        this.f$0 = var1_1;
        this.f$1 = cameraInternal;
        this.f$2 = surfaceRequest;
    }

    public final void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        this.f$0.lambda$onSurfaceRequested$1$PreviewView$1(this.f$1, this.f$2, transformationInfo);
    }
}
