/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbtt
 *  com.google.android.gms.internal.ads.zzbus
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtt;
import com.google.android.gms.internal.ads.zzbus;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzbuq
implements zzfrk {
    private final zzbus zza;
    private final Object zzb;

    zzbuq(zzbus zzbus2, Object object) {
        this.zza = zzbus2;
        this.zzb = object;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzc(this.zzb, (zzbtt)object);
    }
}
