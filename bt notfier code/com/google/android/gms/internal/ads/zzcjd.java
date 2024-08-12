/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.internal.ads.zzcip
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzcip;

final class zzcjd
implements Runnable {
    private final zzcip zza;
    private boolean zzb = false;

    zzcjd(zzcip zzcip2) {
        this.zza = zzcip2;
    }

    private final void zzc() {
        zzs.zza.removeCallbacks((Runnable)this);
        zzs.zza.postDelayed((Runnable)this, 250L);
    }

    @Override
    public final void run() {
        if (this.zzb) return;
        this.zza.zzE();
        this.zzc();
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzE();
    }

    public final void zzb() {
        this.zzb = false;
        this.zzc();
    }
}
