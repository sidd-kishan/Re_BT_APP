/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcii
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcii;

final class zzcik
implements Runnable {
    private final zzcii zza;

    private zzcik(zzcii zzcii2) {
        this.zza = zzcii2;
    }

    static Runnable zza(zzcii zzcii2) {
        return new zzcik(zzcii2);
    }

    @Override
    public final void run() {
        this.zza.zzg();
    }
}
