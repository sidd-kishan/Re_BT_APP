/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsn;

final class zzbtf
implements Runnable {
    private final zzbsn zza;

    private zzbtf(zzbsn zzbsn2) {
        this.zza = zzbsn2;
    }

    static Runnable zza(zzbsn zzbsn2) {
        return new zzbtf(zzbsn2);
    }

    @Override
    public final void run() {
        this.zza.zzi();
    }
}
