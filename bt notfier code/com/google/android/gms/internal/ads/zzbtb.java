/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbsn
 *  com.google.android.gms.internal.ads.zzbtr
 *  com.google.android.gms.internal.ads.zzbts
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbtr;
import com.google.android.gms.internal.ads.zzbts;

final class zzbtb
implements Runnable {
    private final zzbts zza;
    private final zzbtr zzb;
    private final zzbsn zzc;

    zzbtb(zzbts zzbts2, zzbtr zzbtr2, zzbsn zzbsn2) {
        this.zza = zzbts2;
        this.zzb = zzbtr2;
        this.zzc = zzbsn2;
    }

    @Override
    public final void run() {
        this.zza.zzj(this.zzb, this.zzc);
    }
}
