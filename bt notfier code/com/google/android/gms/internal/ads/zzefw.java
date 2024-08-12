/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzcwe
 *  com.google.android.gms.internal.ads.zzcwr
 *  com.google.android.gms.internal.ads.zzcxv
 *  com.google.android.gms.internal.ads.zzdbe
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzefd
 *  com.google.android.gms.internal.ads.zzeft
 *  com.google.android.gms.internal.ads.zzefu
 *  com.google.android.gms.internal.ads.zzefv
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzcwe;
import com.google.android.gms.internal.ads.zzcwr;
import com.google.android.gms.internal.ads.zzcxv;
import com.google.android.gms.internal.ads.zzdbe;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzefd;
import com.google.android.gms.internal.ads.zzeft;
import com.google.android.gms.internal.ads.zzefu;
import com.google.android.gms.internal.ads.zzefv;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzefw
implements zzeec<zzcvh> {
    private final zzcwe zza;
    private final zzefd zzb;
    private final zzfsn zzc;
    private final zzdbe zzd;
    private final ScheduledExecutorService zze;

    public zzefw(zzcwe zzcwe2, zzefd zzefd2, zzdbe zzdbe2, ScheduledExecutorService scheduledExecutorService, zzfsn zzfsn2) {
        this.zza = zzcwe2;
        this.zzb = zzefd2;
        this.zzd = zzdbe2;
        this.zze = scheduledExecutorService;
        this.zzc = zzfsn2;
    }

    static /* synthetic */ zzcwe zzc(zzefw zzefw2) {
        return zzefw2.zza;
    }

    static /* synthetic */ zzdbe zzd(zzefw zzefw2) {
        return zzefw2.zzd;
    }

    public final boolean zza(zzfal zzfal2, zzezz zzezz2) {
        if (zzfal2.zza.zza.zza() == null) return false;
        if (!this.zzb.zza(zzfal2, zzezz2)) return false;
        return true;
    }

    public final zzfsm<zzcvh> zzb(zzfal zzfal2, zzezz zzezz2) {
        return this.zzc.zzb((Callable)new zzeft(this, zzfal2, zzezz2));
    }

    final /* synthetic */ zzcvh zze(zzfal zzfal2, zzezz zzezz2) throws Exception {
        return this.zza.zzab(new zzcxv(zzfal2, zzezz2, null), new zzcwr(zzfal2.zza.zza.zza(), (Runnable)new zzefu(this, zzfal2, zzezz2))).zza();
    }

    final /* synthetic */ void zzf(zzfal zzfal2, zzezz object) {
        zzfal2 = this.zzb.zzb(zzfal2, object);
        int n = object.zzN;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        object = this.zze;
        zzfsd.zzp((zzfsm)zzfsd.zzh((zzfsm)zzfal2, (long)n, (TimeUnit)timeUnit, (ScheduledExecutorService)object), (zzfrz)new zzefv(this), (Executor)this.zzc);
    }
}
