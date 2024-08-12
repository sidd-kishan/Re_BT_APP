/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.core.impl.DeferrableSurface
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.DeferrableSurface;
import com.google.common.util.concurrent.ListenableFuture;

class SurfaceRequest.2
extends DeferrableSurface {
    final SurfaceRequest this$0;

    SurfaceRequest.2(SurfaceRequest surfaceRequest) {
        this.this$0 = surfaceRequest;
    }

    protected ListenableFuture<Surface> provideSurface() {
        return this.this$0.mSurfaceFuture;
    }
}
