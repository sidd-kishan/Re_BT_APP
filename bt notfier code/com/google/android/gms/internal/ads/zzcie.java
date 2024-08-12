/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcig
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcig;

final class zzcie
implements Runnable {
    final zzcig zza;

    zzcie(zzcig zzcig2) {
        this.zza = zzcig2;
    }

    @Override
    public final void run() {
        if (zzcig.zza((zzcig)this.zza) == null) return;
        if (!zzcig.zzb((zzcig)this.zza)) {
            zzcig.zza((zzcig)this.zza).zzk();
            zzcig.zzc((zzcig)this.zza, (boolean)true);
        }
        zzcig.zza((zzcig)this.zza).zzc();
    }
}
