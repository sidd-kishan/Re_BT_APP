/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbtt
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbtt;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;

final class zzbun
implements zzfrk {
    private final String zza;
    private final zzbpr zzb;

    zzbun(String string, zzbpr zzbpr2) {
        this.zza = string;
        this.zzb = zzbpr2;
    }

    public final zzfsm zza(Object object) {
        String string = this.zza;
        zzbpr zzbpr2 = this.zzb;
        object = (zzbtt)object;
        object.zzl(string, zzbpr2);
        return zzfsd.zza((Object)object);
    }
}
