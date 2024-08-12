/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcrf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcrf;

final class zzcre
implements Runnable {
    private final zzcrf zza;
    private final Runnable zzb;

    zzcre(zzcrf zzcrf2, Runnable runnable) {
        this.zza = zzcrf2;
        this.zzb = runnable;
    }

    @Override
    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
