/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdmh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdmh;

final class zzdmf
implements Runnable {
    private final zzdmh zza;
    private final boolean zzb;

    zzdmf(zzdmh zzdmh2, boolean bl) {
        this.zza = zzdmh2;
        this.zzb = bl;
    }

    @Override
    public final void run() {
        this.zza.zzL(this.zzb);
    }
}
