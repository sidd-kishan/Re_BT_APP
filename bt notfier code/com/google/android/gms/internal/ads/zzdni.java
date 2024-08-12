/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdnl
 *  com.google.android.gms.internal.ads.zzdog
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdnl;
import com.google.android.gms.internal.ads.zzdog;

final class zzdni
implements Runnable {
    private final zzdnl zza;
    private final zzdog zzb;

    zzdni(zzdnl zzdnl2, zzdog zzdog2) {
        this.zza = zzdnl2;
        this.zzb = zzdog2;
    }

    @Override
    public final void run() {
        this.zza.zzf(this.zzb);
    }
}
