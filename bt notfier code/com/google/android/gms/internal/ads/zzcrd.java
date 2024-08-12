/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcre
 *  com.google.android.gms.internal.ads.zzcrf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcre;
import com.google.android.gms.internal.ads.zzcrf;

final class zzcrd
implements Runnable {
    private final zzcrf zza;
    private final Runnable zzb;

    zzcrd(zzcrf zzcrf2, Runnable runnable) {
        this.zza = zzcrf2;
        this.zzb = runnable;
    }

    @Override
    public final void run() {
        zzcrf zzcrf2 = this.zza;
        Runnable runnable = this.zzb;
        zzchg.zze.execute((Runnable)new zzcre(zzcrf2, runnable));
    }
}
