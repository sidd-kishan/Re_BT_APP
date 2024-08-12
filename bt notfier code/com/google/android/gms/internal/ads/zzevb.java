/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzevc
 *  com.google.android.gms.internal.ads.zzevf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzevc;
import com.google.android.gms.internal.ads.zzevf;

final class zzevb
implements Runnable {
    private final zzevc zza;
    private final zzbcz zzb;

    zzevb(zzevc zzevc2, zzbcz zzbcz2) {
        this.zza = zzevc2;
        this.zzb = zzbcz2;
    }

    @Override
    public final void run() {
        zzevc zzevc2 = this.zza;
        zzbcz zzbcz2 = this.zzb;
        zzevf.zze((zzevf)zzevc2.zzc).zzbD(zzbcz2);
    }
}
