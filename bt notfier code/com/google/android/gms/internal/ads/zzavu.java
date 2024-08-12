/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzavx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzavx;

final class zzavu
implements Runnable {
    final int zza;
    final int zzb;
    final int zzc;
    final float zzd;
    final zzavx zze;

    zzavu(zzavx zzavx2, int n, int n2, int n3, float f) {
        this.zze = zzavx2;
        this.zza = n;
        this.zzb = n2;
        this.zzc = n3;
        this.zzd = f;
    }

    @Override
    public final void run() {
        zzavx.zza((zzavx)this.zze).zzn(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
