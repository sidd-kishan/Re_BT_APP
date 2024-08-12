/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzezm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzezm;

final class zzezf
implements Runnable {
    private final zzezm zza;

    zzezf(zzezm zzezm2) {
        this.zza = zzezm2;
    }

    @Override
    public final void run() {
        this.zza.zzg();
    }
}
