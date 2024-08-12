/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzfdy<E, V>
implements zzfsm<V> {
    private final E zza;
    private final String zzb;
    private final zzfsm<V> zzc;

    public zzfdy(E e, String string, zzfsm<V> zzfsm2) {
        this.zza = e;
        this.zzb = string;
        this.zzc = zzfsm2;
    }

    public final boolean cancel(boolean bl) {
        return this.zzc.cancel(bl);
    }

    public final V get() throws InterruptedException, ExecutionException {
        return (V)this.zzc.get();
    }

    public final V get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (V)this.zzc.get(l, timeUnit);
    }

    public final boolean isCancelled() {
        return this.zzc.isCancelled();
    }

    public final boolean isDone() {
        return this.zzc.isDone();
    }

    public final String toString() {
        String string = this.zzb;
        int n = System.identityHashCode(this);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 12);
        stringBuilder.append(string);
        stringBuilder.append("@");
        stringBuilder.append(n);
        return stringBuilder.toString();
    }

    public final E zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final void zze(Runnable runnable, Executor executor) {
        this.zzc.zze(runnable, executor);
    }
}
