/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.DeferrableSurfaces
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.DeferrableSurfaces;
import com.google.common.util.concurrent.ListenableFuture;

public final class _$$Lambda$DeferrableSurfaces$pmCedm8iLOMS_IHrIv_Uw2AJ038
implements Runnable {
    private final ListenableFuture f$0;

    public /* synthetic */ _$$Lambda$DeferrableSurfaces$pmCedm8iLOMS_IHrIv_Uw2AJ038(ListenableFuture listenableFuture) {
        this.f$0 = listenableFuture;
    }

    @Override
    public final void run() {
        DeferrableSurfaces.lambda$surfaceListWithTimeout$2((ListenableFuture)this.f$0);
    }
}
