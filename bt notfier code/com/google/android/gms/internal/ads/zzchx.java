/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcig
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcig;

final class zzchx
implements Runnable {
    private final zzcig zza;
    private final int zzb;

    zzchx(zzcig zzcig2, int n) {
        this.zza = zzcig2;
        this.zzb = n;
    }

    @Override
    public final void run() {
        this.zza.zzv(this.zzb);
    }
}
