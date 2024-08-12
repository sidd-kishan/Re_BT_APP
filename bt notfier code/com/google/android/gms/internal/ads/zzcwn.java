/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

final class zzcwn
implements Runnable {
    private final AtomicReference zza;

    zzcwn(AtomicReference atomicReference) {
        this.zza = atomicReference;
    }

    @Override
    public final void run() {
        Runnable runnable = this.zza.getAndSet(null);
        if (runnable == null) return;
        runnable.run();
    }
}
