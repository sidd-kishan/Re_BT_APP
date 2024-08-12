/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraStateRegistry$OnOpenAvailableListener
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraStateRegistry;

public final class _$$Lambda$q0_737uiXXnVhEez_6fh5OPQDB0
implements Runnable {
    private final CameraStateRegistry.OnOpenAvailableListener f$0;

    public /* synthetic */ _$$Lambda$q0_737uiXXnVhEez_6fh5OPQDB0(CameraStateRegistry.OnOpenAvailableListener onOpenAvailableListener) {
        this.f$0 = onOpenAvailableListener;
    }

    @Override
    public final void run() {
        this.f$0.onOpenAvailable();
    }
}
