/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbjq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbjq;

final class zzbjp
implements Runnable {
    private final zzbjq zza;

    zzbjp(zzbjq zzbjq2) {
        this.zza = zzbjq2;
    }

    @Override
    public final void run() {
        this.zza.zzf();
    }
}
