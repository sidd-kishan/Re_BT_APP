/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchf
 *  com.google.android.gms.internal.ads.zzfqx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchf;
import com.google.android.gms.internal.ads.zzfqx;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

final class zzche
extends zzfqx {
    private final Executor zza;

    /* synthetic */ zzche(Executor executor, zzchf zzchf2) {
        this.zza = executor;
    }

    public final boolean awaitTermination(long l, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final void execute(Runnable runnable) {
        this.zza.execute(runnable);
    }

    public final boolean isShutdown() {
        return false;
    }

    public final boolean isTerminated() {
        return false;
    }

    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

    public final List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
