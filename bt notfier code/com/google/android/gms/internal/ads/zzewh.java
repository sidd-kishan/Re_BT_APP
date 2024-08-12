/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzewi
 *  com.google.android.gms.internal.ads.zzewj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzewi;
import com.google.android.gms.internal.ads.zzewj;

final class zzewh
implements Runnable {
    private final zzewi zza;
    private final zzbcz zzb;

    zzewh(zzewi zzewi2, zzbcz zzbcz2) {
        this.zza = zzewi2;
        this.zzb = zzbcz2;
    }

    @Override
    public final void run() {
        zzewi zzewi2 = this.zza;
        zzbcz zzbcz2 = this.zzb;
        zzewj.zzd((zzewj)zzewi2.zzc).zzbD(zzbcz2);
    }
}
