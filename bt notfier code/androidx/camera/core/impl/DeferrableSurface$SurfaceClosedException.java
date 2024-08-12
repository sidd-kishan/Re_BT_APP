/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.DeferrableSurface
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.DeferrableSurface;

public static final class DeferrableSurface.SurfaceClosedException
extends Exception {
    DeferrableSurface mDeferrableSurface;

    public DeferrableSurface.SurfaceClosedException(String string, DeferrableSurface deferrableSurface) {
        super(string);
        this.mDeferrableSurface = deferrableSurface;
    }

    public DeferrableSurface getDeferrableSurface() {
        return this.mDeferrableSurface;
    }
}
