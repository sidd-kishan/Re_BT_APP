/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdpl
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpl;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzdpg
implements zzfrk {
    private final zzdpl zza;
    private final String zzb;

    zzdpg(zzdpl zzdpl2, String string) {
        this.zza = zzdpl2;
        this.zzb = string;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzf(this.zzb, object);
    }
}
