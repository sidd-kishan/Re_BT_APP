/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzeyb
 *  com.google.android.gms.internal.ads.zzeyc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzeyb;
import com.google.android.gms.internal.ads.zzeyc;

final class zzeya
implements Runnable {
    private final zzeyb zza;
    private final zzbcz zzb;

    zzeya(zzeyb zzeyb2, zzbcz zzbcz2) {
        this.zza = zzeyb2;
        this.zzb = zzbcz2;
    }

    @Override
    public final void run() {
        zzeyb zzeyb2 = this.zza;
        zzbcz zzbcz2 = this.zzb;
        zzeyc.zze((zzeyc)zzeyb2.zzc).zzbD(zzbcz2);
    }
}
