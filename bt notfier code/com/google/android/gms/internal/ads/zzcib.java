/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcig
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcig;

final class zzcib
implements Runnable {
    final zzcig zza;

    zzcib(zzcig zzcig2) {
        this.zza = zzcig2;
    }

    @Override
    public final void run() {
        if (zzcig.zza((zzcig)this.zza) == null) return;
        zzcig.zza((zzcig)this.zza).zza();
    }
}
