/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzkf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzkf;

final class zzke
implements Runnable {
    private final zzkf zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;

    zzke(zzkf zzkf2, int n, long l, long l2) {
        this.zza = zzkf2;
        this.zzb = n;
        this.zzc = l;
        this.zzd = l2;
    }

    @Override
    public final void run() {
        zzkf zzkf2 = this.zza;
        int n = this.zzb;
        long l = this.zzc;
        long l2 = this.zzd;
        zzkf.zzb((zzkf)zzkf2).zzW(n, l, l2);
    }
}
