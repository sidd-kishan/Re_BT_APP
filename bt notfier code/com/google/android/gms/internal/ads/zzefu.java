/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzefw
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefw;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;

final class zzefu
implements Runnable {
    private final zzefw zza;
    private final zzfal zzb;
    private final zzezz zzc;

    zzefu(zzefw zzefw2, zzfal zzfal2, zzezz zzezz2) {
        this.zza = zzefw2;
        this.zzb = zzfal2;
        this.zzc = zzezz2;
    }

    @Override
    public final void run() {
        this.zza.zzf(this.zzb, this.zzc);
    }
}
