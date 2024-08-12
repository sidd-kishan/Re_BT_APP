/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaoi
 *  com.google.android.gms.internal.ads.zzapf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaoi;
import com.google.android.gms.internal.ads.zzapf;

final class zzaog
implements Runnable {
    final zzapf zza;
    final zzaoi zzb;

    zzaog(zzaoi zzaoi2, zzapf zzapf2) {
        this.zzb = zzaoi2;
        this.zza = zzapf2;
    }

    @Override
    public final void run() {
        this.zza.zza();
    }
}
