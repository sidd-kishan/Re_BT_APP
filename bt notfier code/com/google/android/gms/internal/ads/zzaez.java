/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafe
 *  com.google.android.gms.internal.ads.zzafm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafe;
import com.google.android.gms.internal.ads.zzafm;

final class zzaez
implements Runnable {
    private final zzafe zza;
    private final zzafm zzb;

    zzaez(zzafe zzafe2, zzafm zzafm2) {
        this.zza = zzafe2;
        this.zzb = zzafm2;
    }

    @Override
    public final void run() {
        this.zza.zzJ(this.zzb);
    }
}
