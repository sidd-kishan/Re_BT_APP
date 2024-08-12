/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbsv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsv;

final class zzbso
implements Runnable {
    private final zzbsv zza;
    private final String zzb;

    zzbso(zzbsv zzbsv2, String string) {
        this.zza = zzbsv2;
        this.zzb = string;
    }

    @Override
    public final void run() {
        this.zza.zzq(this.zzb);
    }
}
