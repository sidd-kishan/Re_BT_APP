/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfmi
 *  com.google.android.gms.internal.ads.zzfoe
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfqt
 *  com.google.android.gms.internal.ads.zzfqu
 *  com.google.android.gms.internal.ads.zzfqw
 *  com.google.android.gms.internal.ads.zzfqy
 *  com.google.android.gms.internal.ads.zzfqz
 *  com.google.android.gms.internal.ads.zzfra
 *  com.google.android.gms.internal.ads.zzfrj
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfrl
 *  com.google.android.gms.internal.ads.zzfrs
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsa
 *  com.google.android.gms.internal.ads.zzfsb
 *  com.google.android.gms.internal.ads.zzfsf
 *  com.google.android.gms.internal.ads.zzfsg
 *  com.google.android.gms.internal.ads.zzfsh
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfst
 *  com.google.android.gms.internal.ads.zzfsy
 *  com.google.android.gms.internal.ads.zzftb
 *  com.google.android.gms.internal.ads.zzftc
 *  com.google.android.gms.internal.ads.zzftd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfmi;
import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfqt;
import com.google.android.gms.internal.ads.zzfqu;
import com.google.android.gms.internal.ads.zzfqw;
import com.google.android.gms.internal.ads.zzfqy;
import com.google.android.gms.internal.ads.zzfqz;
import com.google.android.gms.internal.ads.zzfra;
import com.google.android.gms.internal.ads.zzfrj;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfrl;
import com.google.android.gms.internal.ads.zzfrs;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsa;
import com.google.android.gms.internal.ads.zzfsb;
import com.google.android.gms.internal.ads.zzfsf;
import com.google.android.gms.internal.ads.zzfsg;
import com.google.android.gms.internal.ads.zzfsh;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfst;
import com.google.android.gms.internal.ads.zzfsy;
import com.google.android.gms.internal.ads.zzftb;
import com.google.android.gms.internal.ads.zzftc;
import com.google.android.gms.internal.ads.zzftd;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzfsd
extends zzfsf {
    public static <V> zzfsm<V> zza(V v) {
        if (v != null) return new zzfsh(v);
        return zzfsh.zza;
    }

    public static zzfsm<Void> zzb() {
        return zzfsh.zza;
    }

    public static <V> zzfsm<V> zzc(Throwable throwable) {
        if (throwable == null) throw null;
        return new zzfsg(throwable);
    }

    public static <O> zzfsm<O> zzd(Callable<O> zzftb2, Executor executor) {
        zzftb2 = new zzftb(zzftb2);
        executor.execute((Runnable)zzftb2);
        return zzftb2;
    }

    public static <O> zzfsm<O> zze(zzfrj<O> zzftb2, Executor executor) {
        zzftb2 = new zzftb(zzftb2);
        executor.execute((Runnable)zzftb2);
        return zzftb2;
    }

    public static <V, X extends Throwable> zzfsm<V> zzf(zzfsm<? extends V> zzfsm2, Class<X> zzfqu2, zzfln<? super X, ? extends V> zzfln2, Executor executor) {
        zzfqu2 = new zzfqu(zzfsm2, zzfqu2, zzfln2);
        zzfsm2.zze((Runnable)zzfqu2, zzfst.zzc((Executor)executor, (zzfqw)zzfqu2));
        return zzfqu2;
    }

    public static <V, X extends Throwable> zzfsm<V> zzg(zzfsm<? extends V> zzfsm2, Class<X> zzfqt2, zzfrk<? super X, ? extends V> zzfrk2, Executor executor) {
        zzfqt2 = new zzfqt(zzfsm2, zzfqt2, zzfrk2);
        zzfsm2.zze((Runnable)zzfqt2, zzfst.zzc((Executor)executor, (zzfqw)zzfqt2));
        return zzfqt2;
    }

    public static <V> zzfsm<V> zzh(zzfsm<V> zzfsm2, long l, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (!zzfsm2.isDone()) return zzfsy.zzy(zzfsm2, (long)l, (TimeUnit)timeUnit, (ScheduledExecutorService)scheduledExecutorService);
        return zzfsm2;
    }

    public static <I, O> zzfsm<O> zzi(zzfsm<I> zzfsm2, zzfrk<? super I, ? extends O> zzfqy2, Executor executor) {
        int n = zzfra.zzc;
        if (executor == null) throw null;
        zzfqy2 = new zzfqy(zzfsm2, zzfqy2);
        zzfsm2.zze((Runnable)zzfqy2, zzfst.zzc((Executor)executor, (zzfqw)zzfqy2));
        return zzfqy2;
    }

    public static <I, O> zzfsm<O> zzj(zzfsm<I> zzfsm2, zzfln<? super I, ? extends O> zzfqz2, Executor executor) {
        int n = zzfra.zzc;
        if (zzfqz2 == null) throw null;
        zzfqz2 = new zzfqz(zzfsm2, zzfqz2);
        zzfsm2.zze((Runnable)zzfqz2, zzfst.zzc((Executor)executor, (zzfqw)zzfqz2));
        return zzfqz2;
    }

    public static <V> zzfsm<List<V>> zzk(Iterable<? extends zzfsm<? extends V>> iterable) {
        return new zzfrl((zzfoe)zzfoj.zzo(iterable), true);
    }

    @SafeVarargs
    public static <V> zzfsb<V> zzl(zzfsm<? extends V> ... zzfsmArray) {
        return new zzfsb(false, zzfoj.zzq((Object[])zzfsmArray), null);
    }

    public static <V> zzfsb<V> zzm(Iterable<? extends zzfsm<? extends V>> iterable) {
        return new zzfsb(false, zzfoj.zzo(iterable), null);
    }

    @SafeVarargs
    public static <V> zzfsb<V> zzn(zzfsm<? extends V> ... zzfsmArray) {
        return new zzfsb(true, zzfoj.zzq((Object[])zzfsmArray), null);
    }

    public static <V> zzfsb<V> zzo(Iterable<? extends zzfsm<? extends V>> iterable) {
        return new zzfsb(true, zzfoj.zzo(iterable), null);
    }

    public static <V> void zzp(zzfsm<V> zzfsm2, zzfrz<? super V> zzfrz2, Executor executor) {
        if (zzfrz2 == null) throw null;
        zzfsm2.zze((Runnable)new zzfsa(zzfsm2, zzfrz2), executor);
    }

    public static <V> V zzq(Future<V> future) throws ExecutionException {
        if (!future.isDone()) throw new IllegalStateException(zzfmi.zzd((String)"Future was expected to be done: %s", (Object[])new Object[]{future}));
        return (V)zzftd.zza(future);
    }

    public static <V> V zzr(Future<V> object) {
        try {
            object = zzftd.zza(object);
        }
        catch (ExecutionException executionException) {
            Throwable throwable = executionException.getCause();
            if (!(throwable instanceof Error)) throw new zzftc(throwable);
            throw new zzfrs((Error)throwable);
        }
        return (V)object;
    }
}
