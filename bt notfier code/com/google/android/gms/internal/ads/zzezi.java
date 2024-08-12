/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzezj
 *  com.google.android.gms.internal.ads.zzezm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzezj;
import com.google.android.gms.internal.ads.zzezm;

final class zzezi
implements Runnable {
    private final zzezj zza;
    private final zzbcz zzb;

    zzezi(zzezj zzezj2, zzbcz zzbcz2) {
        this.zza = zzezj2;
        this.zzb = zzbcz2;
    }

    @Override
    public final void run() {
        zzezj zzezj2 = this.zza;
        zzbcz zzbcz2 = this.zzb;
        zzezm.zzd((zzezm)zzezj2.zzc).zzbD(zzbcz2);
    }
}
