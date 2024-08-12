/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzehs
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzehs;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;

final class zzdpj
implements zzfrk {
    private final zzfsm zza;

    zzdpj(zzfsm zzfsm2) {
        this.zza = zzfsm2;
    }

    public final zzfsm zza(Object object) {
        zzfsm zzfsm2 = this.zza;
        if (object == null) return zzfsd.zzc((Throwable)new zzehs(1, "Retrieve required value in native ad response failed."));
        return zzfsm2;
    }
}
