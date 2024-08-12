/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package androidx.camera.core;

import android.view.Surface;

public final class _$$Lambda$bKhot3B1n1f2PgvvZExesMq2yMg
implements Runnable {
    private final Surface f$0;

    public /* synthetic */ _$$Lambda$bKhot3B1n1f2PgvvZExesMq2yMg(Surface surface) {
        this.f$0 = surface;
    }

    @Override
    public final void run() {
        this.f$0.release();
    }
}
