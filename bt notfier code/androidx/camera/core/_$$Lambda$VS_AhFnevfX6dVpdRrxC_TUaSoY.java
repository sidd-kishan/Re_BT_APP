/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.HandlerThread
 */
package androidx.camera.core;

import android.os.HandlerThread;

public final class _$$Lambda$VS_AhFnevfX6dVpdRrxC_TUaSoY
implements Runnable {
    private final HandlerThread f$0;

    public /* synthetic */ _$$Lambda$VS_AhFnevfX6dVpdRrxC_TUaSoY(HandlerThread handlerThread) {
        this.f$0 = handlerThread;
    }

    @Override
    public final void run() {
        this.f$0.quitSafely();
    }
}
