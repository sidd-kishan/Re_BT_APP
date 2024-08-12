/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.view.TextureViewImplementation
 */
package androidx.camera.view;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.TextureViewImplementation;
import com.google.common.util.concurrent.ListenableFuture;

public final class _$$Lambda$TextureViewImplementation$e4Dscbpskcjz_esSSILSDR5pW44
implements Runnable {
    private final TextureViewImplementation f$0;
    private final Surface f$1;
    private final ListenableFuture f$2;
    private final SurfaceRequest f$3;

    public /* synthetic */ _$$Lambda$TextureViewImplementation$e4Dscbpskcjz_esSSILSDR5pW44(TextureViewImplementation textureViewImplementation, Surface surface, ListenableFuture listenableFuture, SurfaceRequest surfaceRequest) {
        this.f$0 = textureViewImplementation;
        this.f$1 = surface;
        this.f$2 = listenableFuture;
        this.f$3 = surfaceRequest;
    }

    @Override
    public final void run() {
        this.f$0.lambda$tryToProvidePreviewSurface$2$TextureViewImplementation(this.f$1, this.f$2, this.f$3);
    }
}
