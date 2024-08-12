/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdmu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdmu;

final class zzdmb
implements Runnable {
    private final zzdmu zza;

    private zzdmb(zzdmu zzdmu2) {
        this.zza = zzdmu2;
    }

    static Runnable zza(zzdmu zzdmu2) {
        return new zzdmb(zzdmu2);
    }

    @Override
    public final void run() {
        this.zza.zzy();
    }
}
