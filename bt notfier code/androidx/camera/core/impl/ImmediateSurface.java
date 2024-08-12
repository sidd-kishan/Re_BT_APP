/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.utils.futures.Futures
 */
package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public final class ImmediateSurface
extends DeferrableSurface {
    private final Surface mSurface;

    public ImmediateSurface(Surface surface) {
        this.mSurface = surface;
    }

    public ListenableFuture<Surface> provideSurface() {
        return Futures.immediateFuture((Object)this.mSurface);
    }
}
