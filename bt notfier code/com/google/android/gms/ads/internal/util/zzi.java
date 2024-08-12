/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzj
 */
package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.zzj;

final class zzi
implements Runnable {
    private final zzj zza;

    zzi(zzj zzj2) {
        this.zza = zzj2;
    }

    @Override
    public final void run() {
        this.zza.zzb();
    }
}
