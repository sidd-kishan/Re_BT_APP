/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcxj
 *  com.google.android.gms.internal.ads.zzdbe
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzeeh
 *  com.google.android.gms.internal.ads.zzehp
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfes
 *  com.google.android.gms.internal.ads.zzffr
 *  com.google.android.gms.internal.ads.zzffu
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxj;
import com.google.android.gms.internal.ads.zzdbe;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzeeh;
import com.google.android.gms.internal.ads.zzehp;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfes;
import com.google.android.gms.internal.ads.zzffr;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzehu<AdT>
implements zzfrk<zzfal, AdT> {
    private final zzfes zza;
    private final zzdbe zzb;
    private final zzffr zzc;
    private final zzffu zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcxj<AdT> zzg;
    private final zzehp zzh;
    private final zzeeh zzi;

    public zzehu(zzfes zzfes2, zzehp zzehp2, zzdbe zzdbe2, zzffr zzffr2, zzffu zzffu2, zzcxj<AdT> zzcxj2, Executor executor, ScheduledExecutorService scheduledExecutorService, zzeeh zzeeh2) {
        this.zza = zzfes2;
        this.zzh = zzehp2;
        this.zzb = zzdbe2;
        this.zzc = zzffr2;
        this.zzd = zzffu2;
        this.zzg = zzcxj2;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzeeh2;
    }

    final /* synthetic */ zzfsm zzb(zzfal zzfal2, zzezz zzezz2, zzeec zzeec2, Throwable throwable) throws Exception {
        throwable = this.zzh;
        zzfac zzfac2 = zzfal2.zzb.zzb;
        zzfal2 = zzfsd.zzh((zzfsm)zzeec2.zzb(zzfal2, zzezz2), (long)zzezz2.zzN, (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)this.zzf);
        throwable.zze(zzfac2, zzezz2, (zzfsm)zzfal2);
        return zzfal2;
    }
}
