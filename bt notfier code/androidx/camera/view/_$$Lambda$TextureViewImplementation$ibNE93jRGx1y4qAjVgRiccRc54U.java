/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.view.TextureViewImplementation
 */
package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.TextureViewImplementation;

public final class _$$Lambda$TextureViewImplementation$ibNE93jRGx1y4qAjVgRiccRc54U
implements Runnable {
    private final TextureViewImplementation f$0;
    private final SurfaceRequest f$1;

    public /* synthetic */ _$$Lambda$TextureViewImplementation$ibNE93jRGx1y4qAjVgRiccRc54U(TextureViewImplementation textureViewImplementation, SurfaceRequest surfaceRequest) {
        this.f$0 = textureViewImplementation;
        this.f$1 = surfaceRequest;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onSurfaceRequested$0$TextureViewImplementation(this.f$1);
    }
}
