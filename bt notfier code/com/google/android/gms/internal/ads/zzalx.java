/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzalz
 *  com.google.android.gms.internal.ads.zzamd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzalz;
import com.google.android.gms.internal.ads.zzamd;

final class zzalx
implements Runnable {
    private final zzamd zza;
    private final zzalz zzb;

    zzalx(zzamd zzamd2, zzalz zzalz2) {
        this.zza = zzamd2;
        this.zzb = zzalz2;
    }

    @Override
    public final void run() {
        zzamd zzamd2 = this.zza;
        this.zzb.zza(zzamd2.zzc());
    }
}
