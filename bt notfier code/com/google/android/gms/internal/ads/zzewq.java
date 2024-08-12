/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdal
 *  com.google.android.gms.internal.ads.zzewt
 *  com.google.android.gms.internal.ads.zzewu
 *  com.google.android.gms.internal.ads.zzewz
 *  com.google.android.gms.internal.ads.zzexn
 *  com.google.android.gms.internal.ads.zzexp
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdal;
import com.google.android.gms.internal.ads.zzewt;
import com.google.android.gms.internal.ads.zzewu;
import com.google.android.gms.internal.ads.zzewz;
import com.google.android.gms.internal.ads.zzexn;
import com.google.android.gms.internal.ads.zzexp;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzewq
implements zzfrk {
    private final zzewu zza;
    private final zzexp zzb;
    private final zzewt zzc;
    private final zzexn zzd;
    private final zzdal zze;

    zzewq(zzewu zzewu2, zzexp zzexp2, zzewt zzewt2, zzexn zzexn2, zzdal zzdal2) {
        this.zza = zzewu2;
        this.zzb = zzexp2;
        this.zzc = zzewt2;
        this.zzd = zzexn2;
        this.zze = zzdal2;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzf(this.zzb, this.zzc, this.zzd, this.zze, (zzewz)object);
    }
}
