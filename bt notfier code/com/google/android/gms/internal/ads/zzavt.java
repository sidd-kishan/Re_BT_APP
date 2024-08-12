/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzavx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzavx;

final class zzavt
implements Runnable {
    final int zza;
    final long zzb;
    final zzavx zzc;

    zzavt(zzavx zzavx2, int n, long l) {
        this.zzc = zzavx2;
        this.zza = n;
        this.zzb = l;
    }

    @Override
    public final void run() {
        zzavx.zza((zzavx)this.zzc).zzm(this.zza, this.zzb);
    }
}
