/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import com.google.common.util.concurrent.ListenableFuture;

public final class _$$Lambda$ImageCapture$W4g17ZQWrYwqNU1YgXV6cLIPxGw
implements Runnable {
    private final ListenableFuture f$0;

    public /* synthetic */ _$$Lambda$ImageCapture$W4g17ZQWrYwqNU1YgXV6cLIPxGw(ListenableFuture listenableFuture) {
        this.f$0 = listenableFuture;
    }

    @Override
    public final void run() {
        ImageCapture.lambda$takePictureInternal$9((ListenableFuture)this.f$0);
    }
}
