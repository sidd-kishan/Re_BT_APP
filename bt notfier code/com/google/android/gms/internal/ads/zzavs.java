/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzavx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzavx;

final class zzavs
implements Runnable {
    final zzanm zza;
    final zzavx zzb;

    zzavs(zzavx zzavx2, zzanm zzanm2) {
        this.zzb = zzavx2;
        this.zza = zzanm2;
    }

    @Override
    public final void run() {
        zzavx.zza((zzavx)this.zzb).zzl(this.zza);
    }
}
