/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcxj
 *  com.google.android.gms.internal.ads.zzdbe
 *  com.google.android.gms.internal.ads.zzeeh
 *  com.google.android.gms.internal.ads.zzehp
 *  com.google.android.gms.internal.ads.zzehu
 *  com.google.android.gms.internal.ads.zzfes
 *  com.google.android.gms.internal.ads.zzffr
 *  com.google.android.gms.internal.ads.zzffu
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcxj;
import com.google.android.gms.internal.ads.zzdbe;
import com.google.android.gms.internal.ads.zzeeh;
import com.google.android.gms.internal.ads.zzehp;
import com.google.android.gms.internal.ads.zzehu;
import com.google.android.gms.internal.ads.zzfes;
import com.google.android.gms.internal.ads.zzffr;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzehv<AdT>
implements zzgla<zzehu<AdT>> {
    private final zzgln<zzfes> zza;
    private final zzgln<zzehp> zzb;
    private final zzgln<zzdbe> zzc;
    private final zzgln<zzffr> zzd;
    private final zzgln<zzffu> zze;
    private final zzgln<zzcxj<AdT>> zzf;
    private final zzgln<Executor> zzg;
    private final zzgln<ScheduledExecutorService> zzh;
    private final zzgln<zzeeh> zzi;

    public zzehv(zzgln<zzfes> zzgln2, zzgln<zzehp> zzgln3, zzgln<zzdbe> zzgln4, zzgln<zzffr> zzgln5, zzgln<zzffu> zzgln6, zzgln<zzcxj<AdT>> zzgln7, zzgln<Executor> zzgln8, zzgln<ScheduledExecutorService> zzgln9, zzgln<zzeeh> zzgln10) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
        this.zze = zzgln6;
        this.zzf = zzgln7;
        this.zzg = zzgln8;
        this.zzh = zzgln9;
        this.zzi = zzgln10;
    }

    public final zzehu<AdT> zza() {
        zzfes zzfes2 = (zzfes)this.zza.zzb();
        zzehp zzehp2 = (zzehp)this.zzb.zzb();
        zzdbe zzdbe2 = (zzdbe)this.zzc.zzb();
        zzffr zzffr2 = (zzffr)this.zzd.zzb();
        zzffu zzffu2 = (zzffu)this.zze.zzb();
        zzcxj zzcxj2 = (zzcxj)this.zzf.zzb();
        zzfsn zzfsn2 = zzchg.zza;
        zzgli.zzb((Object)zzfsn2);
        return new zzehu(zzfes2, zzehp2, zzdbe2, zzffr2, zzffu2, zzcxj2, (Executor)zzfsn2, (ScheduledExecutorService)this.zzh.zzb(), (zzeeh)this.zzi.zzb());
    }
}
