/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsu;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class zzchl<T>
implements zzfsm<T> {
    private final zzfsu<T> zza = zzfsu.zza();

    private static final boolean zza(boolean bl) {
        if (bl) return bl;
        zzt.zzg().zzl((Throwable)new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        return bl;
    }

    public boolean cancel(boolean bl) {
        return this.zza.cancel(bl);
    }

    public final T get() throws ExecutionException, InterruptedException {
        return (T)this.zza.get();
    }

    public final T get(long l, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T)this.zza.get(l, timeUnit);
    }

    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    public final boolean isDone() {
        return this.zza.isDone();
    }

    public final boolean zzc(T t) {
        boolean bl = this.zza.zzp(t);
        zzchl.zza(bl);
        return bl;
    }

    public final boolean zzd(Throwable throwable) {
        boolean bl = this.zza.zzq(throwable);
        zzchl.zza(bl);
        return bl;
    }

    public final void zze(Runnable runnable, Executor executor) {
        this.zza.zze(runnable, executor);
    }
}
