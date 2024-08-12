/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcwe
 *  com.google.android.gms.internal.ads.zzdbe
 *  com.google.android.gms.internal.ads.zzefd
 *  com.google.android.gms.internal.ads.zzefe
 *  com.google.android.gms.internal.ads.zzefw
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcwe;
import com.google.android.gms.internal.ads.zzdbe;
import com.google.android.gms.internal.ads.zzefd;
import com.google.android.gms.internal.ads.zzefe;
import com.google.android.gms.internal.ads.zzefw;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;
import java.util.concurrent.ScheduledExecutorService;

public final class zzefx
implements zzgla<zzefw> {
    private final zzgln<zzcwe> zza;
    private final zzgln<zzefd> zzb;
    private final zzgln<zzdbe> zzc;
    private final zzgln<ScheduledExecutorService> zzd;
    private final zzgln<zzfsn> zze;

    public zzefx(zzgln<zzcwe> zzgln2, zzgln<zzefd> zzgln3, zzgln<zzdbe> zzgln4, zzgln<ScheduledExecutorService> zzgln5, zzgln<zzfsn> zzgln6) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
        this.zze = zzgln6;
    }

    public final zzefw zza() {
        zzcwe zzcwe2 = (zzcwe)this.zza.zzb();
        zzefd zzefd2 = ((zzefe)this.zzb).zza();
        zzdbe zzdbe2 = (zzdbe)this.zzc.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService)this.zzd.zzb();
        zzfsn zzfsn2 = zzchg.zza;
        zzgli.zzb((Object)zzfsn2);
        return new zzefw(zzcwe2, zzefd2, zzdbe2, scheduledExecutorService, zzfsn2);
    }
}
