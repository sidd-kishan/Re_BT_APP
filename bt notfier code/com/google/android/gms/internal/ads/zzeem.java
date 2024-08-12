/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdsw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdsw;

final class zzeem
implements Runnable {
    private final zzdsw zza;

    private zzeem(zzdsw zzdsw2) {
        this.zza = zzdsw2;
    }

    static Runnable zza(zzdsw zzdsw2) {
        return new zzeem(zzdsw2);
    }

    @Override
    public final void run() {
        this.zza.zzb();
    }
}
