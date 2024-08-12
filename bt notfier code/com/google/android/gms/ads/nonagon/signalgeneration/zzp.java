/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzv
 *  com.google.android.gms.internal.ads.zzdrh
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.internal.ads.zzdrh;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzp
implements zzfrk {
    private final zzv zza;
    private final zzdrh[] zzb;
    private final String zzc;

    zzp(zzv zzv2, zzdrh[] zzdrhArray, String string) {
        this.zza = zzv2;
        this.zzb = zzdrhArray;
        this.zzc = string;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzA(this.zzb, this.zzc, (zzdrh)object);
    }
}
