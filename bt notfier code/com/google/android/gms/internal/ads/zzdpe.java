/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzehs
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzehs;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzdpe
implements zzfrk {
    private final zzfsm zza;

    zzdpe(zzfsm zzfsm2) {
        this.zza = zzfsm2;
    }

    public final zzfsm zza(Object object) {
        zzfsm zzfsm2 = this.zza;
        if ((zzcml)object == null) throw new zzehs(1, "Retrieve Web View from image ad response failed.");
        return zzfsm2;
    }
}
