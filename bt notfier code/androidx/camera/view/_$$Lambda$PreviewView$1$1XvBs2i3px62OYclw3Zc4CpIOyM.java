/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.view.PreviewView$1
 */
package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;

public final class _$$Lambda$PreviewView$1$1XvBs2i3px62OYclw3Zc4CpIOyM
implements Runnable {
    private final PreviewView.1 f$0;
    private final SurfaceRequest f$1;

    public /* synthetic */ _$$Lambda$PreviewView$1$1XvBs2i3px62OYclw3Zc4CpIOyM(PreviewView.1 var1_1, SurfaceRequest surfaceRequest) {
        this.f$0 = var1_1;
        this.f$1 = surfaceRequest;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onSurfaceRequested$0$PreviewView$1(this.f$1);
    }
}
