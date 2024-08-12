/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzav
 *  com.google.android.gms.internal.ads.zzcwe
 *  com.google.android.gms.internal.ads.zzdat
 *  com.google.android.gms.internal.ads.zzdss
 *  com.google.android.gms.internal.ads.zzefd
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzav;
import com.google.android.gms.internal.ads.zzcwe;
import com.google.android.gms.internal.ads.zzdat;
import com.google.android.gms.internal.ads.zzdss;
import com.google.android.gms.internal.ads.zzefd;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;
import java.util.concurrent.Executor;

public final class zzefe
implements zzgla<zzefd> {
    private final zzgln<zzcwe> zza;
    private final zzgln<Context> zzb;
    private final zzgln<Executor> zzc;
    private final zzgln<zzdss> zzd;
    private final zzgln<zzfar> zze;
    private final zzgln<zzfln<zzezz, zzav>> zzf;

    public zzefe(zzgln<zzcwe> zzgln2, zzgln<Context> zzgln3, zzgln<Executor> zzgln4, zzgln<zzdss> zzgln5, zzgln<zzfar> zzgln6, zzgln<zzfln<zzezz, zzav>> zzgln7) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
        this.zze = zzgln6;
        this.zzf = zzgln7;
    }

    public final zzefd zza() {
        return new zzefd((zzcwe)this.zza.zzb(), (Context)this.zzb.zzb(), (Executor)this.zzc.zzb(), (zzdss)this.zzd.zzb(), ((zzdat)this.zze).zza(), (zzfln)this.zzf.zzb());
    }
}
