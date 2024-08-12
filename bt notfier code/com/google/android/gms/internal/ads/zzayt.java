/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzayv
 *  com.google.android.gms.internal.ads.zzchl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzchl;
import java.util.concurrent.Future;

final class zzayt
implements Runnable {
    private final zzchl zza;
    private final Future zzb;

    zzayt(zzchl zzchl2, Future future) {
        this.zza = zzchl2;
        this.zzb = future;
    }

    @Override
    public final void run() {
        zzchl zzchl2 = this.zza;
        Future future = this.zzb;
        int n = zzayv.zzd;
        if (!zzchl2.isCancelled()) return;
        future.cancel(true);
    }
}
