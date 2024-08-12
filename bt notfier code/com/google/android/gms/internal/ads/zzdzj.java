/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzdzk
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzdzk;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzdzj
implements zzfrk {
    private final zzdzk zza;
    private final zzcbj zzb;
    private final int zzc;

    zzdzj(zzdzk zzdzk2, zzcbj zzcbj2, int n) {
        this.zza = zzdzk2;
        this.zzb = zzcbj2;
        this.zzc = n;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzb(this.zzb, this.zzc, (Throwable)object);
    }
}
