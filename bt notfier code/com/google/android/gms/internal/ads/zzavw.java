/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzapf
 *  com.google.android.gms.internal.ads.zzavx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzapf;
import com.google.android.gms.internal.ads.zzavx;

final class zzavw
implements Runnable {
    final zzapf zza;
    final zzavx zzb;

    zzavw(zzavx zzavx2, zzapf zzapf2) {
        this.zzb = zzavx2;
        this.zza = zzapf2;
    }

    @Override
    public final void run() {
        this.zza.zza();
    }
}
