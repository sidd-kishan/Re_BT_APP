/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfqx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfqx;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class zzfsp
extends zzfqx {
    private final ExecutorService zza;

    zzfsp(ExecutorService executorService) {
        if (executorService == null) throw null;
        this.zza = executorService;
    }

    public final boolean awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
        return this.zza.awaitTermination(l, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.zza.execute(runnable);
    }

    public final boolean isShutdown() {
        return this.zza.isShutdown();
    }

    public final boolean isTerminated() {
        return this.zza.isTerminated();
    }

    public final void shutdown() {
        this.zza.shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return this.zza.shutdownNow();
    }

    public final String toString() {
        String string = super.toString();
        String string2 = String.valueOf(this.zza);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 2 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append("[");
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
