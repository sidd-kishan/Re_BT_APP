/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzeqh
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzeqh;
import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzeqi<S extends zzerx>
implements zzery<S> {
    private final zzery<S> zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzeqi(zzery<S> zzery2, long l, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzery2;
        this.zzb = l;
        this.zzc = scheduledExecutorService;
    }

    public final zzfsm<S> zza() {
        zzfsm zzfsm2 = this.zza.zza();
        long l = this.zzb;
        zzfsm zzfsm3 = zzfsm2;
        if (l <= 0L) return zzfsd.zzg((zzfsm)zzfsm3, Throwable.class, (zzfrk)zzeqh.zza, (Executor)zzchg.zzf);
        zzfsm3 = zzfsd.zzh((zzfsm)zzfsm2, (long)l, (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)this.zzc);
        return zzfsd.zzg((zzfsm)zzfsm3, Throwable.class, (zzfrk)zzeqh.zza, (Executor)zzchg.zzf);
    }
}
