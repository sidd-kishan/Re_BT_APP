/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaza
 *  com.google.android.gms.internal.ads.zzazj
 *  com.google.android.gms.internal.ads.zzazk
 *  com.google.android.gms.internal.ads.zzbag
 *  com.google.android.gms.internal.ads.zzbao
 *  com.google.android.gms.internal.ads.zzbbz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzbag;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzbbz;

final class zzdtn
implements zzaza {
    private final zzazj zza;
    private final String zzb;
    private final zzbbz zzc;
    private final String zzd;

    zzdtn(zzazj zzazj2, String string, zzbbz zzbbz2, String string2) {
        this.zza = zzazj2;
        this.zzb = string;
        this.zzc = zzbbz2;
        this.zzd = string2;
    }

    public final void zza(zzbao zzbao2) {
        zzazj zzazj2 = this.zza;
        String string = this.zzb;
        zzbbz zzbbz2 = this.zzc;
        String string2 = this.zzd;
        zzazk zzazk2 = (zzazk)zzbao2.zzg().zzau();
        zzazk2.zza(zzazj2);
        zzbao2.zzh(zzazk2);
        zzazj2 = (zzbag)zzbao2.zze().zzau();
        zzazj2.zza(string);
        zzazj2.zzb(zzbbz2);
        zzbao2.zzf((zzbag)zzazj2);
        zzbao2.zzb(string2);
    }
}
