/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.view.PreviewStreamStateObserver
 *  androidx.camera.view.PreviewView$1
 *  androidx.camera.view.PreviewViewImplementation$OnSurfaceNotInUseListener
 */
package androidx.camera.view;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.view.PreviewStreamStateObserver;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;

public final class _$$Lambda$PreviewView$1$3YsXKxxMa6O4k_ovRCC9NgcsPak
implements PreviewViewImplementation.OnSurfaceNotInUseListener {
    private final PreviewView.1 f$0;
    private final PreviewStreamStateObserver f$1;
    private final CameraInternal f$2;

    public /* synthetic */ _$$Lambda$PreviewView$1$3YsXKxxMa6O4k_ovRCC9NgcsPak(PreviewView.1 var1_1, PreviewStreamStateObserver previewStreamStateObserver, CameraInternal cameraInternal) {
        this.f$0 = var1_1;
        this.f$1 = previewStreamStateObserver;
        this.f$2 = cameraInternal;
    }

    public final void onSurfaceNotInUse() {
        this.f$0.lambda$onSurfaceRequested$2$PreviewView$1(this.f$1, this.f$2);
    }
}
