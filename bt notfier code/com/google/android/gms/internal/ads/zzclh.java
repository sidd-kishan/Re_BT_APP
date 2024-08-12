/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzclj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzclj;

final class zzclh
implements Runnable {
    private final zzcjb zza;
    private final boolean zzb;
    private final long zzc;

    zzclh(zzcjb zzcjb2, boolean bl, long l) {
        this.zza = zzcjb2;
        this.zzb = bl;
        this.zzc = l;
    }

    @Override
    public final void run() {
        zzcjb zzcjb2 = this.zza;
        boolean bl = this.zzb;
        long l = this.zzc;
        int n = zzclj.zzd;
        zzcjb2.zzv(bl, l);
    }
}
