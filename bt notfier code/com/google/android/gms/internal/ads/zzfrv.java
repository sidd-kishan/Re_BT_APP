/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfru
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class zzfrv<V>
extends zzfru<V> {
    private final zzfsm<V> zza;

    zzfrv(zzfsm<V> zzfsm2) {
        if (zzfsm2 == null) throw null;
        this.zza = zzfsm2;
    }

    public final boolean cancel(boolean bl) {
        return this.zza.cancel(bl);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return (V)this.zza.get();
    }

    public final V get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (V)this.zza.get(l, timeUnit);
    }

    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    public final boolean isDone() {
        return this.zza.isDone();
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final void zze(Runnable runnable, Executor executor) {
        this.zza.zze(runnable, executor);
    }
}
