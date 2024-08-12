/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzcxu
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzcxu;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsm;

final class zzcxq
implements zzfrk {
    private final zzcxu zza;
    private final zzfrz zzb;
    private final zzfsm zzc;

    zzcxq(zzcxu zzcxu2, zzfrz zzfrz2, zzfsm zzfsm2) {
        this.zza = zzcxu2;
        this.zzb = zzfrz2;
        this.zzc = zzfsm2;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzf(this.zzb, this.zzc, (zzcxg)object);
    }
}
