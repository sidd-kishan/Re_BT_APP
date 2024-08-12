/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzdpl
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzdpl;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzdpd
implements zzfrk {
    private final zzdpl zza;
    private final zzbdl zzb;
    private final zzezz zzc;
    private final zzfac zzd;
    private final String zze;
    private final String zzf;

    zzdpd(zzdpl zzdpl2, zzbdl zzbdl2, zzezz zzezz2, zzfac zzfac2, String string, String string2) {
        this.zza = zzdpl2;
        this.zzb = zzbdl2;
        this.zzc = zzezz2;
        this.zzd = zzfac2;
        this.zze = string;
        this.zzf = string2;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzh(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, object);
    }
}
