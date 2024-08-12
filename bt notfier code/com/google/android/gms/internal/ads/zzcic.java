/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcig
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcig;

final class zzcic
implements Runnable {
    final int zza;
    final int zzb;
    final zzcig zzc;

    zzcic(zzcig zzcig2, int n, int n2) {
        this.zzc = zzcig2;
        this.zza = n;
        this.zzb = n2;
    }

    @Override
    public final void run() {
        if (zzcig.zza((zzcig)this.zzc) == null) return;
        zzcig.zza((zzcig)this.zzc).zzj(this.zza, this.zzb);
    }
}
