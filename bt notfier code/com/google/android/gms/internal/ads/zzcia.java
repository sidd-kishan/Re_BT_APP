/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcig
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcig;

final class zzcia
implements Runnable {
    final String zza;
    final String zzb;
    final zzcig zzc;

    zzcia(zzcig zzcig2, String string, String string2) {
        this.zzc = zzcig2;
        this.zza = string;
        this.zzb = string2;
    }

    @Override
    public final void run() {
        if (zzcig.zza((zzcig)this.zzc) == null) return;
        zzcig.zza((zzcig)this.zzc).zzf(this.zza, this.zzb);
    }
}
