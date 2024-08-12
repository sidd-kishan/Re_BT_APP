/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdmh
 *  com.google.android.gms.internal.ads.zzdog
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdmh;
import com.google.android.gms.internal.ads.zzdog;

final class zzdme
implements Runnable {
    private final zzdmh zza;
    private final zzdog zzb;

    zzdme(zzdmh zzdmh2, zzdog zzdog2) {
        this.zza = zzdmh2;
        this.zzb = zzdog2;
    }

    @Override
    public final void run() {
        this.zza.zzM(this.zzb);
    }
}
