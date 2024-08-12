/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadr
 *  com.google.android.gms.internal.ads.zzadt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadr;
import com.google.android.gms.internal.ads.zzadt;

final class zzadq
implements Runnable {
    private final zzadr zza;
    private final int zzb;

    zzadq(zzadr zzadr2, int n) {
        this.zza = zzadr2;
        this.zzb = n;
    }

    @Override
    public final void run() {
        zzadr zzadr2 = this.zza;
        int n = this.zzb;
        zzadt.zzd((zzadt)zzadr2.zza, (int)n);
    }
}
