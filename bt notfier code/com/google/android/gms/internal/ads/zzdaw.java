/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcxw
 *  com.google.android.gms.internal.ads.zzcxx
 *  com.google.android.gms.internal.ads.zzcxy
 *  com.google.android.gms.internal.ads.zzdav
 *  com.google.android.gms.internal.ads.zzeeh
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxw;
import com.google.android.gms.internal.ads.zzcxx;
import com.google.android.gms.internal.ads.zzcxy;
import com.google.android.gms.internal.ads.zzdav;
import com.google.android.gms.internal.ads.zzeeh;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdaw
implements zzgla<zzdav> {
    private final zzgln<zzezz> zza;
    private final zzgln<String> zzb;
    private final zzgln<zzeeh> zzc;
    private final zzgln<zzfac> zzd;

    public zzdaw(zzgln<zzezz> zzgln2, zzgln<String> zzgln3, zzgln<zzeeh> zzgln4, zzgln<zzfac> zzgln5) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
    }

    public final zzdav zza() {
        return new zzdav(((zzcxw)this.zza).zza(), ((zzcxx)this.zzb).zza(), (zzeeh)this.zzc.zzb(), ((zzcxy)this.zzd).zza());
    }
}
