/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.SurfaceRequest
 *  androidx.core.util.Consumer
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.Consumer;

public final class _$$Lambda$SurfaceRequest$1B_FEIX2iizhnKAclUlsKNJ3zuM
implements Runnable {
    private final Consumer f$0;
    private final Surface f$1;

    public /* synthetic */ _$$Lambda$SurfaceRequest$1B_FEIX2iizhnKAclUlsKNJ3zuM(Consumer consumer, Surface surface) {
        this.f$0 = consumer;
        this.f$1 = surface;
    }

    @Override
    public final void run() {
        SurfaceRequest.lambda$provideSurface$5((Consumer)this.f$0, (Surface)this.f$1);
    }
}
