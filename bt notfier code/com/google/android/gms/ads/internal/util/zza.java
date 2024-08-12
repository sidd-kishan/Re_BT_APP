/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzb
 */
package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.zzb;

final class zza
implements Runnable {
    final zzb zza;

    zza(zzb zzb2) {
        this.zza = zzb2;
    }

    @Override
    public final void run() {
        zzb.zzb((zzb)this.zza, (Thread)Thread.currentThread());
        this.zza.zza();
    }
}
