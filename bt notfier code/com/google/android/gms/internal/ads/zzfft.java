/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzffu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzffu;

final class zzfft
implements Runnable {
    private final zzffu zza;
    private final String zzb;

    zzfft(zzffu zzffu2, String string) {
        this.zza = zzffu2;
        this.zzb = string;
    }

    @Override
    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
