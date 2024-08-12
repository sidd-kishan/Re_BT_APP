/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbif
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbif;

final class zzbie
implements Runnable {
    private final zzbif zza;

    zzbie(zzbif zzbif2) {
        this.zza = zzbif2;
    }

    @Override
    public final void run() {
        this.zza.zzb();
    }
}
