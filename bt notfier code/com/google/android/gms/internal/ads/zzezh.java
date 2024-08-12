/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzezc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzezc;

final class zzezh
implements Runnable {
    private final zzezc zza;

    private zzezh(zzezc zzezc2) {
        this.zza = zzezc2;
    }

    static Runnable zza(zzezc zzezc2) {
        return new zzezh(zzezc2);
    }

    @Override
    public final void run() {
        this.zza.zzf();
    }
}
