/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzeam
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzeam;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzcye
implements zzfrk {
    private final zzeam zza;

    private zzcye(zzeam zzeam2) {
        this.zza = zzeam2;
    }

    static zzfrk zzb(zzeam zzeam2) {
        return new zzcye(zzeam2);
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzc((zzcbj)object);
    }
}
