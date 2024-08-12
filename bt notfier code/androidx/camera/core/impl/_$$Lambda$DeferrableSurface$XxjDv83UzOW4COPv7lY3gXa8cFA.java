/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.DeferrableSurface
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.DeferrableSurface;

public final class _$$Lambda$DeferrableSurface$XxjDv83UzOW4COPv7lY3gXa8cFA
implements Runnable {
    private final DeferrableSurface f$0;
    private final String f$1;

    public /* synthetic */ _$$Lambda$DeferrableSurface$XxjDv83UzOW4COPv7lY3gXa8cFA(DeferrableSurface deferrableSurface, String string) {
        this.f$0 = deferrableSurface;
        this.f$1 = string;
    }

    @Override
    public final void run() {
        this.f$0.lambda$new$1$DeferrableSurface(this.f$1);
    }
}
